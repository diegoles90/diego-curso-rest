package com.in28minutes.rest.webservices.restful.webservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWVnbyIsImV4cCI6MTYzNDgyNzc4MiwiaWF0IjoxNjM0MjIyOTgyfQ.Tn_X2_yAP2rOfs7E5y3lnvuwiq_tJN8T3BLbVCKEViiSH3yiua-pPsaJgFou2WC41BQKuCuEZnZun9AwQ7A5_A"
//    }


    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

