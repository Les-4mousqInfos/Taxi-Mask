package fr.et.intechinfo.mousqinfos.taximask.controllers;

import com.stripe.model.Charge;
import fr.et.intechinfo.mousqinfos.taximask.payload.response.StripeResponse;
import fr.et.intechinfo.mousqinfos.taximask.services.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/stripe-public-key")
    public ResponseEntity <?> getPublicKey() {
        return ResponseEntity.ok().body(stripePublicKey);
    }



    @PostMapping("/charge-card")
    public ResponseEntity<?> chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getParameter("stripeToken");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Charge charge= stripeService.chargeNewCard(token, amount);
        StripeResponse res = new StripeResponse();
        res.setId(charge.getId());
        res.setChargeId(charge.getId());
        res.setStatus(charge.getStatus());
        res.setBalanceTransaction(charge.getBalanceTransaction());
        return ResponseEntity.ok().body(res);
    }
}
