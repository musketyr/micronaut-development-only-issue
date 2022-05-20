package workerg.demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import jakarta.inject.Singleton

@Slf4j
@Singleton
@CompileStatic
class FallbackEmailDigestService implements EmailDigestService {

    void sendEmail(String email) {
        log.info "Sending email to $email"
    }

}