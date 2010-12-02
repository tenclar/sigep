package br.com.sigep.controller;


import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Row;

import org.zkoss.zul.Messagebox;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class ResultadoFinalController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;

	private DataBinder binder;
	
	private Button resultadoFinal;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox anoLetivoCombo;
	private Row RowSerie;
	private Row RowNivel;
	private Row RowTurma;
		
	Turma turmav = null;
	
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	
	public Serie getS() {
		return s;
	}

	public void setS(Serie s) {
		this.s = s;
	}
	

	public NivelEscolar getNe1() {
		return ne1;
	}

	public void setNe1(NivelEscolar ne1) {
		this.ne1 = ne1;
	}

	public AnoLetivo getAnoletivoObj() {
		return anoletivoObj;
	}

	public void setAnoletivoObj(AnoLetivo anoletivoObj) {
		this.anoletivoObj = anoletivoObj;
	}
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
			
		anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
  	 	long idNivelEscolarComparar = 0;
  	 	if(Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId()).isEmpty() == true){
  	 		Messagebox.show("Não existem Níveis Escolares cadastrados para este ano! Favor cadastrá-los!",
  			        "Atenção!",
  			        Messagebox.OK,
  			        Messagebox.EXCLAMATION,
  			        new org.zkoss.zk.ui.event.EventListener() {
  						public void onEvent(Event arg1) throws Exception {
  						}
  					}
  			);
  	 	}else{
  	 		
  	 	nivelCombo.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId())) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	 		if(idNivelEscolarComparar != ne.getId()){
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivelCombo.appendChild(comboitem);
  	 		}
  	 		idNivelEscolarComparar = ne.getId();
	 	}
  	 	
  	 	nivelCombo.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	}
	  	
	}
	
	public void onSelect$nivelCombo(Event e) {
  	 	
		ne1 = ((NivelEscolar) nivelCombo.getSelectedItem().getValue());
		
  	 	serieCombo.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne1.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(se.getDescricao());
			comboitem.setValue(se);
			serieCombo.appendChild(comboitem);
	 	}
  	 	
  	 	serieCombo.setDisabled(false);
  	 	binder.loadComponent(RowSerie); 	
  	
	}
	
	public void onSelect$serieCombo(){

		s = ((Serie) serieCombo.getSelectedItem().getValue());
		turmaCombo.getChildren().clear();
  	 	for (Turma t : Facade.getInstance().listarTurmaSerie(s.getId(), anoletivoObj.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(t.getNome());
			comboitem.setValue(t);
			turmaCombo.appendChild(comboitem);
	 	}
  	 	
  	 	turmaCombo.setDisabled(false);
  	 	binder.loadComponent(RowTurma); 
		
	}
	
	public void onSelect$turmaCombo(){
		resultadoFinal.setDisabled(false);
	}

	public void onClick$resultadoFinal() throws InterruptedException{

		turmav = ((Turma) turmaCombo.getSelectedItem().getValue());
		
		Facade.getInstance().calcularResultadoTurma(turmav);

		Messagebox.show("Resultado Final Gerado com Sucesso!",
		        "Informação!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		
	}

}
