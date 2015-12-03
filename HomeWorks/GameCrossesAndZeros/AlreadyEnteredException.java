/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ILMAZ
 */
public class AlreadyEnteredException extends Exception {
    private String msg;
    public AlreadyEnteredException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
    
}
