package com.daw.gestion_socios.controladoras;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.daw.gestion_socios.modelos.Cuota;
import com.daw.gestion_socios.modelos.Socio;
import com.daw.gestion_socios.servicios.CuotaService;
import com.daw.gestion_socios.servicios.SocioService;

@Controller
@RequestMapping("/cuota")
public class CuotaController {

    private final CuotaService cuotaService;
    private final SocioService socioService;

    public CuotaController(CuotaService cuotaService, SocioService socioService) {
        this.cuotaService = cuotaService;
        this.socioService = socioService;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false) Integer anio,
            @RequestParam(defaultValue = "false") boolean pendientes,
            Model model) {
        List<Cuota> todasLasCuotas = cuotaService.listarTodas();
        List<Cuota> cuotas = new ArrayList<>();

        for (Cuota cuota : todasLasCuotas) {
            boolean coincideAnio = true;
            if (anio != null && !cuota.getAnio().equals(anio)) {
                coincideAnio = false;
            }

            boolean estaPendiente = true;
            if (pendientes && cuota.getFecha_pago() != null) {
                estaPendiente = false;
            }

            if (coincideAnio && estaPendiente) {
                cuotas.add(cuota);
            }
        }

        model.addAttribute("cuotas", cuotas);
        model.addAttribute("anio", anio);
        model.addAttribute("pendientes", pendientes);
        return "list_cuotas";
    }

    @GetMapping("/nuevo")
    public String nueva(Model model) {
        model.addAttribute("socios", socioService.listarTodos());
        model.addAttribute("cuota", new Cuota());
        return "form_cuotas";
    }

    @PostMapping("/guardar")
    public String guardar(
            @RequestParam Long socioId,
            @RequestParam Integer anio,
            @RequestParam Float importe) {
        Optional<Socio> socioEncontrado = socioService.buscarPorId(socioId);
        if (socioEncontrado.isEmpty()) {
            return "redirect:/cuota";
        }
        Socio socio = socioEncontrado.get();

        List<Cuota> todasLasCuotas = cuotaService.listarTodas();
        for (Cuota cuotaGuardada : todasLasCuotas) {
            if (cuotaGuardada.getSocio().getId().equals(socioId)
                    && cuotaGuardada.getAnio().equals(anio)) {
                return "redirect:/cuota/nuevo?error=duplicada";
            }
        }

        Cuota cuota = new Cuota();
        cuota.setSocio(socio);
        cuota.setAnio(anio);
        cuota.setImporte(importe);
        cuotaService.guardar(cuota);
        return "redirect:/cuota";
    }

    @PostMapping("/pagar/{id}")
    public String registrarPago(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaPago) {
        Optional<Cuota> cuotaEncontrada = cuotaService.buscarPorId(id);
        if (cuotaEncontrada.isEmpty()) {
            return "redirect:/cuota";
        }
        Cuota cuota = cuotaEncontrada.get();
        cuota.setFecha_pago(fechaPago);
        cuotaService.guardar(cuota);
        return "redirect:/cuota";
    }
}
