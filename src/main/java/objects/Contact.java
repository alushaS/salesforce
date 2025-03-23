package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.core.config.AppenderRef;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    private String contactLastName;
    private String accountName;
    private String phone;
    private String email;
}
