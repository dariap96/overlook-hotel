package itmo.com.overlook.hotel.controllers;

import itmo.com.overlook.hotel.services.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String generateReport() throws JRException, FileNotFoundException {
        return reportService.exportReport("pdf");
    }
}
