package com.filedownload.Controller;

import com.filedownload.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserDetails {
    @Autowired
    private JdbcTemplate template;

    @PostMapping("/records")
    public ResponseEntity<?> saveUser(@RequestBody Customer customer) {
        String sql = "insert into customer(name,accounttype,accountnumber,status,mobilenumber)VALUES(?,?,?,?,?)";
        int update = template.update(sql, customer.getName(), customer.getAccounttype(), customer.getAccountnumber(), customer.getStatus(), customer.getMobilenumber());
        return new ResponseEntity<>(update, HttpStatus.CREATED);

    }

    @GetMapping("/getrecords")
    public ResponseEntity<Customer> getCustomer(@RequestParam String mobileNumber) {
        /*try {
            String sql = "select * from customer where mobilenumber=?";
            List<Map<String, Object>> response = template.queryForList(sql, mobileNumber);
            return ResponseEntity.ok(response.get(0));
        }

            // return new ResponseEntity<>(response,HttpStatus.OK);
        catch(EmptyResultDataAccessException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No customer found with mobile number: " + mobileNumber);
            }
        catch (Exception e) {
            // Unexpected error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Something went wrong", "error", e.getMessage()));
        }*/

        String sql = "select * from customer where mobilenumber=?";
        RowMapper<Customer> USER_ROW_MAPPER = (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setMobilenumber(rs.getString("mobilenumber"));
            customer.setName(rs.getString("name"));
            customer.setAccounttype(rs.getString("accounttype"));
            customer.setAccountnumber(rs.getString("accountnumber"));
            customer.setStatus(rs.getString("status"));
            return customer;
            // return template.queryForObject(sql, new Object[]{mobileNumber}, USER_ROW_MAPPER);
        };
        try {
            Customer customer = template.queryForObject(sql, new Object[]{mobileNumber}, USER_ROW_MAPPER);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            // Handle case where no customer is found and return null in response body
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }
}

