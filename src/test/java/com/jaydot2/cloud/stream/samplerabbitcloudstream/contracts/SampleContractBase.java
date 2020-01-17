package com.jaydot2.cloud.stream.samplerabbitcloudstream.contracts;

import org.junit.runner.RunWith;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureMessageVerifier
@RunWith(SpringRunner.class)
public abstract class SampleContractBase {
}
