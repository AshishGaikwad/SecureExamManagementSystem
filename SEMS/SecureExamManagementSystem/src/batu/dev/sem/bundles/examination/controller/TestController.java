package batu.dev.sem.bundles.examination.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class TestController {
	  @GET
	    public String getMsg()
	    {
	         return "Hello World !! - Jersey 2";
	    }
}
