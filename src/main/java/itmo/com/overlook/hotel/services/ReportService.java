package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.entities.Booking;
import itmo.com.overlook.hotel.repositories.BookingRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private BookingRepository bookingsRepo;

    public String exportReport(String format) throws FileNotFoundException, JRException {
        List<Booking> bookings = bookingsRepo.findAll();
        File file = ResourceUtils.getFile("classpath:bookings.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookings);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "dariap96");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "/Users/dariapomazan/Desktop/bookings.html");
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/dariapomazan/Desktop/bookings.pdf");
        }
        return "report has been exported";
    }
}
