package com.isadent.cotizaciones.microservicio.Infraestructure.Services;

import com.isadent.cotizaciones.microservicio.Application.Dtos.NewQuotation;
import com.isadent.cotizaciones.microservicio.Domain.BussinesLogic.NewIsadentQuotation;
import com.isadent.cotizaciones.microservicio.Domain.BussinesLogic.TotalPriceProcedures;
import com.isadent.cotizaciones.microservicio.Domain.Events.PublishPayment;
import com.isadent.cotizaciones.microservicio.Domain.Events.PublishIsadentQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.Payment;
import com.isadent.cotizaciones.microservicio.Domain.Model.IsadentQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.PublishedQuotation;
import com.isadent.cotizaciones.microservicio.Domain.Model.ImprovementPlan;
import com.isadent.cotizaciones.microservicio.Domain.Repository.ImprovementPlanRepository;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Provides details to retrieve a Quotation to the patient's including dental procedures, prices, and values in a money format
 */
@Component
public class NewIsadentQuotationImp implements NewIsadentQuotation<NewQuotation> {
    private final CurrencyFormat currencyFormat;
    private final QuotationDate quotationDate;
    private final TotalPriceProcedures totalPriceProcedures;
    private final ImprovementPlanRepository<NewQuotation> improvementPlanRepository;
    private final PublishPayment publishPayment;
    private final PublishIsadentQuotation<PublishedQuotation> publishIsadentQuotation;

    public NewIsadentQuotationImp(CurrencyFormat currencyFormat, QuotationDate quotationDate,
                                  TotalPriceProcedures totalPriceProcedures,
                                  ImprovementPlanRepository<NewQuotation> planDeMejoraJpaRepository,
                                  PublishPayment publishPayment, PublishIsadentQuotation<PublishedQuotation> publishIsadentQuotation) {
        this.currencyFormat = currencyFormat;
        this.quotationDate = quotationDate;
        this.totalPriceProcedures = totalPriceProcedures;
        this.improvementPlanRepository = planDeMejoraJpaRepository;
        this.publishPayment = publishPayment;
        this.publishIsadentQuotation = publishIsadentQuotation;
    }

    /**
     *
     * @param newQuotation the input data for creating the new quotation includes: a list of dental procedures, patient's name, and payment
     *
     * @return a Quotation ready to be converted to pdf with relevant information
     */
    @Override
    public IsadentQuotation createNewIsadentQuotation(NewQuotation newQuotation) {
        //Set the payment money format
        String abonoCurrency = currencyFormat.createMoneyFormat(newQuotation.getPayment());
        // consults the dental procedures prices in the database
        List<ImprovementPlan> improvementPlan = improvementPlanRepository.getImprovementPlan(newQuotation);
        //calculate the Quotation's total amount
        Double totalPrice = improvementPlan.stream().map(ImprovementPlan::getPrice).reduce(0.0, Double::sum);
        Double total = totalPriceProcedures.procedimietoTotal(totalPrice, newQuotation.getPayment());
        // Create the quotation date
        String date = quotationDate.createQuotationDate();
        // create the money format for the total
        String totalCurrency = currencyFormat.createMoneyFormat(total);
        // instance a new Payment to send it to the Payment microservice
        Payment paymentToSend = new Payment(newQuotation.getPatientName(), newQuotation.getPayment());
        publishPayment.publishNewPayment(paymentToSend);
        // when the information needed is ready we create the view for the Quotation
        IsadentQuotation isadent = new IsadentQuotation();
        isadent.setPatientName(newQuotation.getPatientName());
        isadent.setImprovementPlan(improvementPlan);
        isadent.setPaymentDate(date);
        isadent.setTotal(totalCurrency);
        isadent.setPayment(abonoCurrency);
        PublishedQuotation publishedQuotation = new PublishedQuotation(improvementPlan, newQuotation.getPayment(), newQuotation.getPatientName(),
                total,date
                );
        //publish the event to the Bill microservice
        publishIsadentQuotation.publishQuotation(publishedQuotation);
        return isadent;

    }
}
