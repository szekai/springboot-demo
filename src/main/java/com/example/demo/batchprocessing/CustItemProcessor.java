package com.example.demo.batchprocessing;

import com.example.demo.models.CustomerTrx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CustItemProcessor implements ItemProcessor<CustomerTrx, CustomerTrx> {

	private static final Logger log = LoggerFactory.getLogger(CustItemProcessor.class);

	@Override
	public CustomerTrx process(final CustomerTrx customerTrx) throws Exception {
		final String accNUmber = customerTrx.getAccNumber();
		final String trxAmount = customerTrx.getTrxAmount();
		final String description = customerTrx.getDescription();
		final String trxDate = customerTrx.getTrxDate();
		final String time = customerTrx.getTrxTime();
		final String custId = customerTrx.getCustId();
		final CustomerTrx transformedCustomerTrx = new CustomerTrx(accNUmber, trxAmount, description, trxDate, time, custId);

		log.info("Converting (" + customerTrx + ") into (" + transformedCustomerTrx + ")");

		return transformedCustomerTrx;
	}

}
