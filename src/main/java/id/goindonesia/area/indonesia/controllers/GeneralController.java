package id.goindonesia.area.indonesia.controllers;

import id.goindonesia.area.indonesia.commons.GeneralErrorResponse;
import id.goindonesia.area.indonesia.commons.ResponseData;
import id.goindonesia.area.indonesia.commons.ResponseStatus;
import id.goindonesia.area.indonesia.services.MergedSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

/**
 * Created by ghostzali on 26/04/17.
 */
@RestController
public class GeneralController {

    @Autowired
    private MergedSearchService mergedSearchService;

    @GetMapping(path = "/", produces = "application/json")
    @PostMapping(path = "/", produces = "application/json")

    public ResponseData get(){
        return new ResponseData(ResponseStatus.OK,
                "Area - Indonesia | Powered by GO Indonesia",
                "Database based on https://github.com/edwardsamuel/Wilayah-Administratif-Indonesia");
    }

    @GetMapping(path = "/search", produces = "application/json")
    public ResponseData searchFromAll(@QueryParam("keyword") String keyword) {
        try {
            return new ResponseData(ResponseStatus.OK, "Success", mergedSearchService.searchFromAll(keyword));
        } catch (Exception e) {
            return GeneralErrorResponse.error(e);
        }
    }
}
