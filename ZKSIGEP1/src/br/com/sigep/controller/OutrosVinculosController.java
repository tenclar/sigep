package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Funcionario;
import br.com.sigep.bean.OutrosVinculos;
import br.com.sigep.facade.Facade;

public class OutrosVinculosController extends GenericForwardComposer{

	private Div cadastroOutrosVinculos;
	private Div janelaProcurarOutrosVinculos;
	private Listbox ListagemVinculo;
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox cargo;
	private Textbox orgao;
	private Intbox cargaHoraria;
	private Textbox cpfDoFuncionario;
	private Textbox cpfDoFuncionario2;
	private Groupbox groupboxProcurarFuncionario;
	private Groupbox groupboxIdentificacaoDoFuncionario;
	private Groupbox groupboxIdentificacaoDoFuncionario2;
	private Groupbox groupboxOutrosVinculos;
	private Groupbox groupboxListaDeOutrosVinculos;
	private Label funcaoFuncionario;
	private Label nomeFuncionario;
	private Label funcaoFuncionario2;
	private Label nomeFuncionario2;
	private Constraint c = null;

	private static final long serialVersionUID = 1L;
	
	OutrosVinculos vinculo = new OutrosVinculos();
	Funcionario funcionarioEncontrado = null;

	public OutrosVinculos getVinculos() {
		return vinculo;
	}

	public void setVinculos(OutrosVinculos vinculos) {
		this.vinculo = vinculos;
	}

	public Funcionario getFuncionarioEncontrado() {
		return funcionarioEncontrado;
	}

	public void setFuncionarioEncontrado(Funcionario funcionarioEncontrado) {
		this.funcionarioEncontrado = funcionarioEncontrado;
	}

	public void onClick$adicionar(Event e) throws InterruptedException {
		
		vinculo.setCargo(cargo.getValue());
		vinculo.setOrgao(orgao.getValue());
		vinculo.setCargaHoraria(cargaHoraria.getValue());
		
		funcionarioEncontrado.getOutrosVinculos().add(vinculo);
		Facade.getInstance().atualizarFuncionario(funcionarioEncontrado);
	
		Messagebox.show("Vínculo Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		vinculo = new OutrosVinculos();
		cadastroOutrosVinculos.setVisible(false);
	}
	
	public void  onClick$procurarDadosDoFuncionario(Event e) throws InterruptedException{
		
		if(cpfDoFuncionario.getValue() == null){
			
			Messagebox.show("Insira um CPF!",
					"Atenção!",
					Messagebox.OK,
					Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
						}
			);
					
		}else{
			
			funcionarioEncontrado = Facade.getInstance().procurarFuncionarioPorCPF(cpfDoFuncionario.getValue());
			
			groupboxIdentificacaoDoFuncionario.setVisible(false);
			groupboxOutrosVinculos.setVisible(false);
		
			if(funcionarioEncontrado != null){
		
				nomeFuncionario.setValue(funcionarioEncontrado.getNome());
				funcaoFuncionario.setValue(funcionarioEncontrado.getFuncao());
				
				groupboxIdentificacaoDoFuncionario.setVisible(true);
				groupboxOutrosVinculos.setVisible(true);
				
				
			}else{
				Messagebox.show("Não existe Funcionário com este CPF!",
						"Atenção!",
						Messagebox.OK,
						Messagebox.EXCLAMATION,
						new org.zkoss.zk.ui.event.EventListener() {
							public void onEvent(Event arg1) throws Exception {
							}
  						}
				);
			
			}
		
		}
  	
	}
	
	public void onClick$ListarOutrosVinculos(){
		
		cadastroOutrosVinculos.setVisible(false);
		groupboxIdentificacaoDoFuncionario2.setVisible(false);
		groupboxListaDeOutrosVinculos.setVisible(false);
		cpfDoFuncionario2.setConstraint(c);
		cpfDoFuncionario2.setText("");
		cpfDoFuncionario2.setConstraint("no empty, /[0-9]+/:Este campo não pode ser vazio! Preencha-o somente com números!");
		
		janelaProcurarOutrosVinculos.setVisible(true);

	}

	public void onClick$CadastrarOutrosVinculos(){
		cadastroOutrosVinculos.setVisible(true);
		groupboxProcurarFuncionario.setVisible(true);
		groupboxIdentificacaoDoFuncionario.setVisible(false);
		groupboxOutrosVinculos.setVisible(false);
		janelaProcurarOutrosVinculos.setVisible(false);
		adicionar.setVisible(true);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		cpfDoFuncionario.setConstraint(c);
		cargaHoraria.setConstraint(c);
		orgao.setConstraint(c);
		cargo.setConstraint(c);
		
		cpfDoFuncionario.setText("");
		cargaHoraria.setText("");
		orgao.setText("");
		cargo.setText("");
		
		cpfDoFuncionario.setConstraint("no empty, /[0-9]+/:Este campo não pode ser vazio! Preencha-o somente com números!");
		cargaHoraria.setConstraint("no empty, no negative, no zero");
		orgao.setConstraint("no empty");
		cargo.setConstraint("no empty");
		
	}
	
	public void  onClick$procurarDadosDoFuncionario2(Event e) throws InterruptedException{
		
		if(cpfDoFuncionario2.getValue() == null){
			
			Messagebox.show("Insira um CPF!",
					"Atenção!",
					Messagebox.OK,
					Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
						}
			);
		
			
		}else{
			
		
			funcionarioEncontrado = Facade.getInstance().procurarFuncionarioPorCPF(cpfDoFuncionario2.getValue());
	
			if(funcionarioEncontrado != null){
		
				nomeFuncionario2.setValue(funcionarioEncontrado.getNome());
				funcaoFuncionario2.setValue(funcionarioEncontrado.getFuncao());
		
				groupboxIdentificacaoDoFuncionario2.setVisible(true);
		
				listModel = new ListModelList(Facade.getInstance().listarOutrosVinculosFuncionario(funcionarioEncontrado.getId()));
				ListagemVinculo.setModel(listModel);
		
				groupboxListaDeOutrosVinculos.setVisible(true);
		
	    
			}else{
				Messagebox.show("Não existe Funcionário com este CPF!",
						"Atenção!",
						Messagebox.OK,
						Messagebox.EXCLAMATION,
						new org.zkoss.zk.ui.event.EventListener() {
							public void onEvent(Event arg1) throws Exception {
							}
						}
				);
			
			}
		}
  	
	}
	
	
	public void onClick$EditarOutrosVinculos() throws InterruptedException {
		if(groupboxListaDeOutrosVinculos.isVisible() && ListagemVinculo.getSelectedIndex()!=-1){
			
			janelaProcurarOutrosVinculos.setVisible(false);
			cadastroOutrosVinculos.setVisible(true);
			groupboxProcurarFuncionario.setVisible(false);
			groupboxIdentificacaoDoFuncionario.setVisible(false);
			groupboxOutrosVinculos.setVisible(true);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);
			
			vinculo = (OutrosVinculos) ListagemVinculo.getModel().getElementAt(ListagemVinculo.getSelectedIndex());
			
			cargo.setText(vinculo.getCargo());
			orgao.setText(vinculo.getOrgao());
			cargaHoraria.setText(String.valueOf(vinculo.getCargaHoraria()));
			
			cargaHoraria.setConstraint("no empty, no negative, no zero");
			orgao.setConstraint("no empty");
			cargo.setConstraint("no empty");
			
		}
		else{
			Messagebox.show("Selecione um Item!",
		        "Item Não Selecionado!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg0) throws Exception {				
					}
				}
			);
			
		}
	}
	
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		
		OutrosVinculos ov = Facade.getInstance().carregarOutrosVinculos(((OutrosVinculos)ListagemVinculo.getModel().getElementAt(ListagemVinculo.getSelectedIndex())).getId());
		
		ov.setCargaHoraria(cargaHoraria.getValue());
		ov.setCargo(cargo.getValue());
		ov.setOrgao(orgao.getValue());
		
		Facade.getInstance().atualizarOutrosVinculos(ov);
		
		cadastroOutrosVinculos.setVisible(false);
		janelaProcurarOutrosVinculos.setVisible(false);

		listModel = new ListModelList(Facade.getInstance().listarOutrosVinculosFuncionario(funcionarioEncontrado.getId()));
		ListagemVinculo.setModel(listModel);
		
		Messagebox.show("Vínculo Alterado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
	}
		
	public void onClick$cancelar(Event e) {	
		cadastroOutrosVinculos.setVisible(false);
		janelaProcurarOutrosVinculos.setVisible(false);
	}

				
	public void onClick$DeletarOutrosVinculos(Event event) throws InterruptedException {  
		if(groupboxListaDeOutrosVinculos.isVisible() && ListagemVinculo.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar o Vínculo selecionado?",
				        "Você tem Certeza?",
				        Messagebox.YES+Messagebox.NO,
				        Messagebox.EXCLAMATION,
				        new org.zkoss.zk.ui.event.EventListener() {
							public void onEvent(Event event) {
								if ("onYes".equals(event.getName())) {
									doYes();
								}
							}
						}
					);
			} catch (InterruptedException ex) {
			} 
			}
			else{
				Messagebox.show("Selecione um Item!",
				        "Item Não Selecionado!",
			        Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg0) throws Exception {
							//refreshModel();			
						}
					}
				);
				
			}
	 } 
		
	public void doYes() {
		Facade.getInstance().removerOutrosVinculos(((OutrosVinculos) ListagemVinculo.getModel().getElementAt(ListagemVinculo.getSelectedIndex())).getId());
		
		listModel = new ListModelList(Facade.getInstance().listarOutrosVinculosFuncionario(funcionarioEncontrado.getId()));
		ListagemVinculo.setModel(listModel);
	}

}
