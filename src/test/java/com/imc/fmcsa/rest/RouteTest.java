package com.imc.fmcsa.rest;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;
import org.springframework.util.Assert;

import com.imc.fmcsa.unified.SaferBus;

public class RouteTest extends CamelBlueprintTestSupport {

	@Produce(uri = "cxfrs:bean:saferBusRestClient?httpClientAPI=false")
	protected ProducerTemplate template;

	@Override
	protected String getBlueprintDescriptor() {
		return "OSGI-INF/blueprint/service-routes.xml";
	}

	@Test
	public void testRoute() {
		Exchange exchange = template.send(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.setPattern(ExchangePattern.InOut);
				Message inMessage = exchange.getIn();
				// set the operation name
				inMessage.setHeader(CxfConstants.OPERATION_NAME, "queryByName");

				inMessage.setBody(new MessageContentsList("greyhound",
						new SaferBus.QueryParameters(null, null, "MC")));
			}
		});

		// get the response message
		if (exchange.isFailed()) {
			exchange.getException().printStackTrace();
			fail();
		}
		Assert.notNull(exchange.getOut().getBody());
	}

}
