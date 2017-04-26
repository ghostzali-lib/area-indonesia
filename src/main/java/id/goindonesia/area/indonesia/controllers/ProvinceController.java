package id.goindonesia.area.indonesia.controllers;

import id.goindonesia.area.indonesia.commons.GeneralErrorResponse;
import id.goindonesia.area.indonesia.commons.ResponseData;
import id.goindonesia.area.indonesia.commons.ResponseStatus;
import id.goindonesia.area.indonesia.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

/**
 * Created by ghostzali on 22/04/17.
 */
@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping(path = "/province/all", produces = "application/json")
    public ResponseData getAll() {
        try {
            return new ResponseData(ResponseStatus.OK, "Success", provinceService.findAll());
        } catch (Exception e) {
            return GeneralErrorResponse.error(e);
        }
    }

    @GetMapping(path = "/province/one", produces = "application/json")
    public ResponseData getOne(@QueryParam("code") Integer code) {
        try {
            return new ResponseData(ResponseStatus.OK, "Success", provinceService.findByCode(code));
        } catch (Exception e) {
            return GeneralErrorResponse.error(e);
        }
    }

    @GetMapping(path = "/province/search", produces = "application/json")
    public ResponseData search(@QueryParam("keyword") String keyword) {
        try {
            return new ResponseData(ResponseStatus.OK, "Success", provinceService.findByKeyword(keyword));
        } catch (Exception e) {
            return GeneralErrorResponse.error(e);
        }
    }

}
