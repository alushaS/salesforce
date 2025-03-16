package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    private String contactFirstName;
    private String contactLastName;
    private String accountName;
}
