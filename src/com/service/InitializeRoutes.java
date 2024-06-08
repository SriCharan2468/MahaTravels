package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Route;

public class InitializeRoutes {

	public static List<Route> initializeRoutes() {
		List<Route> routes = new ArrayList<>();
		routes.add(new Route(101, "Nellore", "Hyderabad", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(102, "Nellore", "Hyderabad", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(103, "Nellore", "Hyderabad", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(104, "Nellore", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(105, "Nellore", "Chennai", LocalDate.now(), 500, 40, "seater"));
		routes.add(new Route(106, "Nellore", "Chennai", LocalDate.now(), 1000, 40, "sleeper"));
		routes.add(new Route(107, "Nellore", "Chennai", LocalDate.now().plusDays(1), 500, 40, "seater"));
		routes.add(new Route(108, "Nellore", "Chennai", LocalDate.now().plusDays(1), 1000, 40, "sleeper"));
		routes.add(new Route(109, "Nellore", "Bangalore", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(110, "Nellore", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(111, "Nellore", "Bangalore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(112, "Nellore", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(113, "Hyderabad", "Nellore", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(114, "Hyderabad", "Nellore", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(115, "Hyderabad", "Nellore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(116, "Hyderabad", "Nellore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(117, "Hyderabad", "Chennai", LocalDate.now(), 1500, 40, "seater"));
		routes.add(new Route(118, "Hyderabad", "Chennai", LocalDate.now(), 2000, 40, "sleeper"));
		routes.add(new Route(119, "Hyderabad", "Chennai", LocalDate.now().plusDays(1), 1500, 40, "seater"));
		routes.add(new Route(120, "Hyderabad", "Chennai", LocalDate.now().plusDays(1), 2000, 40, "sleeper"));
		routes.add(new Route(121, "Hyderabad", "Bangalore", LocalDate.now(), 1200, 40, "seater"));
		routes.add(new Route(122, "Hyderabad", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(123, "Hyderabad", "Bangalore", LocalDate.now().plusDays(1), 1200, 40, "seater"));
		routes.add(new Route(124, "Hyderabad", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(125, "Chennai", "Nellore", LocalDate.now(), 500, 40, "seater"));
		routes.add(new Route(126, "Chennai", "Nellore", LocalDate.now(), 700, 40, "sleeper"));
		routes.add(new Route(127, "Chennai", "Nellore", LocalDate.now().plusDays(1), 500, 40, "seater"));
		routes.add(new Route(128, "Chennai", "Nellore", LocalDate.now().plusDays(1), 700, 40, "sleeper"));
		routes.add(new Route(129, "Chennai", "Hyderabad", LocalDate.now(), 1500, 40, "seater"));
		routes.add(new Route(130, "Chennai", "Hyderabad", LocalDate.now(), 2000, 40, "sleeper"));
		routes.add(new Route(131, "Chennai", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "seater"));
		routes.add(new Route(132, "Chennai", "Hyderabad", LocalDate.now().plusDays(1), 2000, 40, "sleeper"));
		routes.add(new Route(133, "Chennai", "Bangalore", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(134, "Chennai", "Bangalore", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(135, "Chennai", "Bangalore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(136, "Chennai", "Bangalore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(137, "Bangalore", "Nellore", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(138, "Bangalore", "Nellore", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(139, "Bangalore", "Nellore", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(140, "Bangalore", "Nellore", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(141, "Bangalore", "Chennai", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(142, "Bangalore", "Chennai", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(143, "Bangalore", "Chennai", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(144, "Bangalore", "Chennai", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		routes.add(new Route(145, "Bangalore", "Hyderabad", LocalDate.now(), 1000, 40, "seater"));
		routes.add(new Route(146, "Bangalore", "Hyderabad", LocalDate.now(), 1500, 40, "sleeper"));
		routes.add(new Route(147, "Bangalore", "Hyderabad", LocalDate.now().plusDays(1), 1000, 40, "seater"));
		routes.add(new Route(148, "Bangalore", "Hyderabad", LocalDate.now().plusDays(1), 1500, 40, "sleeper"));
		return routes;
	}

}
