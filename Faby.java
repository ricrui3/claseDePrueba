package mx.ipn.escom.cdt.capacitacion.informacionbase.controller;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.cdt.capacitacion.informacionbase.bs.EmpresaBs;
import mx.ipn.escom.cdt.capacitacion.informacionbase.bs.EspecialistaBs;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Cuenta;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Empresa;
import mx.ipn.escom.cdt.capacitacion.informacionbase.model.Especialista;
import mx.ipn.escom.cdt.util.bs.GenericSearchBs;

@Namespace("/informacion-base")
public class GestionarEspecialistaCtrl extends ActionSupport {

	private static final long serialVersionUID = 3146026177803211416L;
	
	@Autowired
	private GenericSearchBs genericSearchBs;
	@Autowired
	private EspecialistaBs especialistaBs;
	private Integer idSel;
	private List<Especialista> listEspecialistas;
	private Especialista model;
	private Cuenta cuenta;
	
	public String index(){
		listEspecialistas = genericSearchBs.findAll(Especialista.class);
		return "index";
	}
	
	public String editNew(){
		return "editNew";
	}
	
	public String edit(){
		return "edit";
	}
	
	public String show(){
		System.err.println(model);
		return "show";
	}
	
	public String deleteConfirm(){
		return "deleteConfirm";
	}
	
	public String destroy(){
		especialistaBs.delete(model);
		return index();
	}
	
	public String update(){
		especialistaBs.update(model);
		return index();
	}
	
	public String create(){
		especialistaBs.guardar(model, cuenta);
		return index();
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public EspecialistaBs getEspecialistaBs() {
		return especialistaBs;
	}

	public void setEspecialistaBs(EspecialistaBs especialistaBs) {
		this.especialistaBs = especialistaBs;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		if(idSel != null){
			model = genericSearchBs.findById(Especialista.class, idSel);
		}
		this.idSel = idSel;
	}

	public List<Especialista> getListEspecialistas() {
		return listEspecialistas;
	}

	public void setListEspecialistas(List<Especialista> listEspecialistas) {
		this.listEspecialistas = listEspecialistas;
	}

	public Especialista getModel() {
		if(model == null){
			this.model = new Especialista();
		}
		return model;
	}

	public void setModel(Especialista model) {
		this.model = model;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


}

