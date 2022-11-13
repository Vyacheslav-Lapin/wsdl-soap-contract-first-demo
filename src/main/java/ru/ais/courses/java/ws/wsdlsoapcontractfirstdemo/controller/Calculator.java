package ru.ais.courses.java.ws.wsdlsoapcontractfirstdemo.controller;

import com.medium.types.calculator.AdditionInput;
import com.medium.types.calculator.DivisionInput;
import com.medium.types.calculator.MultiplicationInput;
import com.medium.types.calculator.ObjectFactory;
import com.medium.types.calculator.Output;
import com.medium.types.calculator.SubtractionInput;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class Calculator {

  @ResponsePayload
  @SuppressWarnings({"unused","java:S1192"})
  @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "AdditionInput")
  public Output addition(@RequestPayload AdditionInput input) {
    log.info("Request received for addition with input {}", input);
    val objectFactory = new ObjectFactory();
    val output = objectFactory.createOutput();
    output.setResult(input.getNumber1() + input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "SubtractionInput")
  public Output subtraction(@RequestPayload SubtractionInput input) {
    log.info("Request received for addition with input {}", input);
    val objectFactory = new ObjectFactory();
    val output = objectFactory.createOutput();
    output.setResult(input.getNumber1() - input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "MultiplicationInput")
  public Output multiplication(@RequestPayload MultiplicationInput input) {
    log.info("Request received for addition with input {}", input);
    val objectFactory = new ObjectFactory();
    val output = objectFactory.createOutput();
    output.setResult(input.getNumber1() * input.getNumber2());
    return output;
  }

  @ResponsePayload
  @SuppressWarnings("unused")
  @PayloadRoot(namespace = "http://medium.com/types/calculator", localPart = "DivisionInput")
  public Output division(@RequestPayload DivisionInput input) {
    log.info("Request received for addition with input {}", input);

    if (input.getNumber2() == 0)
      throw new IllegalArgumentException("Divisor can't be null");

    val objectFactory = new ObjectFactory();
    val output = objectFactory.createOutput();

    output.setResult(input.getNumber1() / input.getNumber2());
    return output;
  }
}
