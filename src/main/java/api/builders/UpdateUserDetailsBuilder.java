package api.builders;

import api.models.UpdateUserDetailsRequest;
import utils.DataGenerator;
import utils.RandomGeneratorTypes;

public class UpdateUserDetailsBuilder
{
    private String DOB = "15/10/1988";

    private String firstName = DataGenerator.getRamdomDataFor(RandomGeneratorTypes.FirstName);

    private String lastname = DataGenerator.getRamdomDataFor(RandomGeneratorTypes.LastName);

    private String email = DataGenerator.generateRandomEmail();

    public UpdateUserDetailsBuilder getDOB(String dob)
    {
        this.DOB = dob;
        return this;
    }
    public UpdateUserDetailsBuilder getFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public UpdateUserDetailsBuilder getLastName(String lastName)
    {
        this.lastname = lastName;
        return this;

    }

    public UpdateUserDetailsBuilder getEmail(String email)
    {
        this.email = email;
        return this;
    }


    public UpdateUserDetailsRequest build()
    {
        return new UpdateUserDetailsRequest(firstName,lastname,DOB,email);
    }

}
