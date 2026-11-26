package com.daw.gestion_socios.controladoras;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.gestion_socios.modelos.Carnet;
import com.daw.gestion_socios.modelos.Socio;
import com.daw.gestion_socios.servicios.CarnetService;
import com.daw.gestion_socios.servicios.SocioService;

@Controller
@RequestMapping("/carnet")
public class CarnetController {

    private final CarnetService carnetService;
    private final SocioService socioService;

    public CarnetController(CarnetService carnetService, SocioService socioService) {
        this.carnetService = carnetService;
        this.socioService = socioService;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("socios", socioService.listarTodos());
        model.addAttribute("carnet", new Carnet());
        return "form_carnets";
    }

    @PostMapping("/guardar")
    public String guardar(
            @RequestParam Long socioId,
            @RequestParam String numero,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaEmision,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCaducidad) {
        Optional<Socio> socioEncontrado = socioService.buscarPorId(socioId);
        if (socioEncontrado.isEmpty()) {
            return "redirect:/carnet/nuevo";
        }
        Socio socio = socioEncontrado.get();
        if (socio.getCarnet() != null) {
            return "redirect:/carnet/nuevo?error=socio-con-carnet";
        }
        List<Carnet> carnets = carnetService.listarTodos();
        for (Carnet carnetGuardado : carnets) {
            if (carnetGuardado.getNumero().equals(numero)) {
                return "redirect:/carnet/nuevo?error=numero-duplicado";
            }
        }

        Carnet carnet = new Carnet();
        carnet.setSocio(socio);
        carnet.setNumero(numero);
        carnet.setFecha_emision(fechaEmision);
        carnet.setFecha_caducidad(fechaCaducidad);
        carnetService.guardar(carnet);
        return "redirect:/socio/" + socioId;
    }

    @PostMapping("/renovar/{id}")
    public String renovar(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaEmision,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCaducidad) {
        Optional<Carnet> carnetEncontrado = carnetService.buscarPorId(id);
        if (carnetEncontrado.isEmpty()) {
            return "redirect:/carnet/nuevo";
        }
        Carnet carnet = carnetEncontrado.get();
        carnet.setFecha_emision(fechaEmision);
        carnet.setFecha_caducidad(fechaCaducidad);
        carnetService.guardar(carnet);
        return "redirect:/socio/" + carnet.getSocio().getId();
    }
}
