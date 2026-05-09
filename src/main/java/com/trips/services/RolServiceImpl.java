package com.trips.services;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Rol;

@Service
public class RolServiceImpl implements IRolService {

	private List<Rol> lista = null;

	public RolServiceImpl() {
		lista = new LinkedList<>();

		// ROL 1
		Rol r1 = new Rol();
		r1.setId(1);
		r1.setNombre("Administrador");
		r1.setDescripcion("Acceso total a todos los módulos y configuración del sistema.");
		r1.setEstado(true);
		r1.setFechaCreacion(LocalDate.now());

		// ROL 2
		Rol r2 = new Rol();
		r2.setId(2);
		r2.setNombre("Vendedor");
		r2.setDescripcion("Permisos para gestionar ventas, facturación y catálogo de productos.");
		r2.setEstado(true);
		r2.setFechaCreacion(LocalDate.now());

		// ROL 3
		Rol r3 = new Rol();
		r3.setId(3);
		r3.setNombre("Cliente");
		r3.setDescripcion("Usuario final con acceso a perfil personal y al catalogo.");
		r3.setEstado(true);
		r3.setFechaCreacion(LocalDate.now());

		// ROL 4
		Rol r4 = new Rol();
		r4.setId(4);
		r4.setNombre("Auditor");
		r4.setDescripcion("Acceso de solo lectura para revisión de logs y reportes financieros.");
		r4.setEstado(false); 
		r4.setFechaCreacion(LocalDate.now());

		lista.add(r1);
		lista.add(r2);
		lista.add(r3);
		lista.add(r4);
	}

	@Override
	public List<Rol> buscarTodo() {
		return lista;
	}

	@Override
	public Rol buscarPorId(Integer idRol) {
		for (Rol r : lista) {
			if (r.getId().equals(idRol)) {
				return r;
			}
		}
		return null;
	}

	@Override
	public <buscarTodos> List<Rol> buscarTodos() {
		return null;
	}
}