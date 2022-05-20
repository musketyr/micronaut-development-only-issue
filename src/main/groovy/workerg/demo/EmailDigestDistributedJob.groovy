package workerg.demo

import com.agorapulse.worker.annotation.Cron
import com.agorapulse.worker.annotation.FixedRate
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

@Singleton
@CompileStatic
class EmailDigestDistributedJob {

    private final EmailDigestService emailDigestService

    EmailDigestDistributedJob(EmailDigestService emailDigestService) {
        this.emailDigestService = emailDigestService
    }

    @Cron('45 6 * * *')
    Iterable<String> generateEmailsForDigest() {
        return ['user@example.com']
    }

    @FixedRate('1s')
    void sendEmail(String email) {
        emailDigestService.sendEmail(email)
    }

}