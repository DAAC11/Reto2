package com.desaextremo.retodos;

import com.desaextremo.retodos.entity.Gadget;
import com.desaextremo.retodos.entity.User;
import com.desaextremo.retodos.repository.GadgetRepositoy;
import com.desaextremo.retodos.repository.UserRepository;
import com.desaextremo.retodos.service.GadgetService;
import com.desaextremo.retodos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GadgetRepositoy gadgetRepositoy;

	@Autowired
	private UserService userService;

	@Autowired
	private GadgetService gadgetService;

	public static void main(String[] args) {
		SpringApplication.run(RetodosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//borrado inicial de datos
		userRepository.deleteAll();
		gadgetRepositoy.deleteAll();

		/*
		//cargar datos
		userRepository.saveAll(List.of(
				new User(1, "123123", "ALAN BRITO", "CR 34-45", "311222222", "abrito@gmail.com", "Demo123.", "ZONA 2", "ADM"),
				new User(2, "61123211", "NAPOLEON BONAPARTE", "CR 34-45", "3168965645", "nbonaparte@gmail.com", "Demo123.", "ZONA 2", "COORD"),
				new User(3, "46669989", "BLODY MARRY", "CR 34-45", "3174565625", "stellez@gmail.com", "Demo123.", "ZONA 2", "ASE"),
				new User(4, "52369563", "JUANA DE ARCO", "CR 34-45", "3265632", "jdarco@gmail.com", "Demo123.", "ZONA 2", "ASE"),
				new User(5, "123456789", "ALCIRA LA ALPACA",  "CR 34-45", "3168965645", "aalpaca@gmail.com", "Demo123.", "ZONA 1", "COORD"),
				new User(6, "213456789", "PEDRO CAPAROSA", "CR 34-45", "3168965645", "pcaparosa@gmail.com", "Demo123.", "ZONA 1", "ASE"),
				new User(7, "312456789", "LUIS IXV UN SOL", "CR 34-45", "3168965645", "reysol@gmail.com", "Demo123.", "ZONA 1", "ASE")
		));

		gadgetRepositoy.saveAll(List.of(
				new Gadget(1, "GENIUS", "MOUSE", "SUPER MOUSE", "MOUSE PARA VIDEO GAMERS", 250000, true, 10, "https://www.avasoluciones.com/mouse1.jpg"),
				new Gadget(2, "Coredy", "ROBOT", "Coredy Robot aspirador R650", "Personaliza tu propia aspiradora robot: elige tu imagen única o favorita para personalizar la piel de aspiradora robótica R650, esta será tu mejor opción para expresar personalidad, mostrar tu amor y preservar momentos maravillosos. (Personalízalo ahora en otro enlace)", 180000, true, 10, "https://www.avasoluciones.com/mouse.jpg")
		));

		//listar datos desde el repositorio


		List<Gadget> listadoGadgets =  gadgetRepositoy.findAll();


		System.out.println("Listado de gatgets");
		for (Gadget gadget:listadoGadgets) {
			System.out.println(gadget.toString());
		}
		 */

		//listar datos desde la capa service o de negocio
		/*
		List<Gadget> listadoGadgets = gadgetService.getAll();

		System.out.println("Listado de gatgets");
		for (Gadget gadget : listadoGadgets) {
			System.out.println(gadget.toString());
		}

		//listar datos desde el repositorio

		List<User> listadoUsers =  userRepository.findAll();

		System.out.println("Listado de usuarios");
		for (User user:listadoUsers) {
			System.out.println(user.toString());
		}


		List<User> listadoUsers =  userService.getAll();

		System.out.println("Listado de usuarios");
		for (User user:listadoUsers) {
			System.out.println(user.toString());
		}
		*/
		//validar si un email existe
		/*
		System.out.println("El metodo retorno " + userService.existEmail("serpengblack@gmail.com"));
		System.out.println("El metodo retorno " + userService.existEmail("serpent@gmail.com"));

		System.out.println("El metodo retorno " + userService.existEmail("abrito@gmail.com"));
		System.out.println("El metodo retorno " + userService.existEmail("pcaparosa@gmail.com"));

		//Validar autenticacion

		//existen
		System.out.println("Datos del usuario" + userService.autenticateUser("abrito@gmail.com","Demo123."));
		System.out.println("Datos del usuario" + userService.autenticateUser("pcaparosa@gmail.com","Demo123."));

		//no existen
		System.out.println("Datos del usuario" + userService.autenticateUser("serpengblack@gmail.com","Demo123."));
		System.out.println("Datos del usuario" + userService.autenticateUser("serpent@gmail.com","Demo123."));

		//Validar un usuario por su id
		System.out.println(" datos del usuario \n"+userService.getUser(1));
		System.out.println(" datos del usuario \n"+userService.getUser(666));
		*/
	}
}
