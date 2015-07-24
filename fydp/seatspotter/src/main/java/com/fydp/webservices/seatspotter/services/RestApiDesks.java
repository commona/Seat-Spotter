package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.Desk;

@Path("/libraries/{libraryId}/floors/{floorId}/deskhubs/{deskHubId}/desks")
public class RestApiDesks {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Desk> getDesks(@PathParam("deskHubId") int deskHubId){
		List<Desk> desks = new ArrayList<Desk>();
		ResultSet rs;
		
		List<Integer> params = new ArrayList<Integer>();
		params.add(deskHubId);
		
		rs=DBManager.executeProcedureWithParam(DBConstants.GET_DESKS, params);
		
		try {
			while (rs.next()){
				int deskId = rs.getInt("DeskId");
				int deskState = rs.getInt("DeskState");
				
				desks.add(new Desk(deskId, deskState));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return desks;
	}
	
}
