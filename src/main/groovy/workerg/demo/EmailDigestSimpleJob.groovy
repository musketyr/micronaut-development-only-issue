package workerg.demo

import com.agorapulse.worker.annotation.Cron
import groovy.transform.CompileStatic
import jakarta.inject.Singleton

@Singleton
@CompileStatic
class EmailDigestSimpleJob {

    private final EmailDigestService emailDigestService

    EmailDigestSimpleJob(EmailDigestService emailDigestService) {
        this.emailDigestService = emailDigestService
    }

    @Cron('45 6 * * *')
    void sendDigestEmail() {
        emailDigestService.sendEmail('user@example.com')
    }

    int getEmailsSent() {
        return emailsSent
    }

}