package workerg.demo

import com.agorapulse.worker.JobManager
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject

import spock.lang.Specification
import spock.util.concurrent.PollingConditions

@MicronautTest
class EmailDigestSimpleJobSpec extends Specification {

    PollingConditions conditions = new PollingConditions()
    List<String> emailsSent = []

    @MockBean(FallbackEmailDigestService)
    EmailDigestService emailDigestService = Mock {
        sendEmail(_) >> { String email -> emailsSent << email }
    }

    @Inject JobManager jobManager

    void 'send email using simple job'() {
        when:
        jobManager.forceRun(EmailDigestSimpleJob)

        then:
        conditions.eventually {
            'user@example.com' in emailsSent
        }
    }

}