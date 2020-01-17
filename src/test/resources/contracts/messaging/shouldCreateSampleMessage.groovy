import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('This is a sample messaging contract')
    label('Sample Contract')
    input {
        triggeredBy('makeSomeMessage()')
    }
    outputMessage {
        headers {
            header([
                    contentType('application/json')
            ])
        }
        body([
                result: alphaNumeric()
        ])
    }
}