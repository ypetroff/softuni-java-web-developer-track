package bg.softuni.resellerapp.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {

    private Long id;

    //TODO: check if you need to store the username
    private String username;

    public boolean isEmpty() {
        return this.id == null;
    }

    public void clearUser() {
        this.id = null;
        //TODO: see if you need username
        this.username = null;

    }
}
