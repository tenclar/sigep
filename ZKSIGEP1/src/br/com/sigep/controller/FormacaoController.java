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
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Formacao;
import br.com.sigep.bean.Funcionario;
import br.com.sigep.facade.Facade;

public class FormacaoController extends GenericForwardComposer{

	private Div cadastroFormacao;
	private Div janelaProcurarFormacao;
	private Listbox ListagemFormacao;
	private Listheader EspecializacaoFormacao;
	private Listcell listcellEspecializacao;
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox titulo;
	private Row rowEspecializacao;
	private Textbox especializacao;
	private Textbox curso;
	private Textbox instituicao;
	private Intbox ano;
	private Textbox cpfDoFuncionario;
	private Textbox cpfDoFuncionario2;
	private Groupbox groupboxProcurarFuncionario;
	private Groupbox groupboxIdentificacaoDoFuncionario;
	private Groupbox groupboxIdentificacaoDoFuncionario2;
	private Groupbox groupboxFormacao;
	private Groupbox groupboxListaDeFormacao;
	private Label funcaoFuncionario;
	private Label nomeFuncionario;
	private Label funcaoFuncionario2;
	private Label nomeFuncionario2;
	
	private Constraint c = null;

	private static final long serialVersionUID = 1L;
	
	Formacao formacao = new Formacao();
	Funcionario funcionarioEncontrado = null;

	
	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Funcionario getFuncionarioEncontrado() {
		return funcionarioEncontrado;
	}

	public void setFuncionarioEncontrado(Funcionario funcionarioEncontrado) {
		this.funcionarioEncontrado = funcionarioEncontrado;
	}

	public void onClick$adicionar(Event e) throws InterruptedException {
		
		formacao.setTitulo(titulo.getValue());
		formacao.setCurso(curso.getValue());
		formacao.setAnoConclusao(ano.getValue());
		formacao.setInstituicao(instituicao.getValue());

		funcionarioEncontrado.getFormacao().add(formacao);
		Facade.getInstance().atualizarFuncionario(funcionarioEncontrado);
	
		Messagebox.show("Formação Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		formacao = new Formacao();
		cadastroFormacao.setVisible(false);
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
			groupboxFormacao.setVisible(false);
		
			if(funcionarioEncontrado != null){
				
				
				if(funcionarioEncontrado.getFuncao() == "Professor"){
					rowEspecializacao.setVisible(true);
				}else{
					rowEspecializacao.setVisible(false);
				}
				
				nomeFuncionario.setValue(funcionarioEncontrado.getNome());
				funcaoFuncionario.setValue(funcionarioEncontrado.getFuncao());
				
				groupboxIdentificacaoDoFuncionario.setVisible(true);
				groupboxFormacao.setVisible(true);
				
				
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
	
	
	
	public void onClick$ListarFormacao(){
		
		cadastroFormacao.setVisible(false);
		groupboxIdentificacaoDoFuncionario2.setVisible(false);
		groupboxListaDeFormacao.setVisible(false);
		cpfDoFuncionario2.setConstraint(c);
		cpfDoFuncionario2.setText("");
		cpfDoFuncionario2.setConstraint("no empty, /[0-9]+/:Este campo não pode ser vazio! Preencha-o somente com números!");
		janelaProcurarFormacao.setVisible(true);

	}

	public void onClick$CadastrarFormacao(){
		cadastroFormacao.setVisible(true);
		groupboxProcurarFuncionario.setVisible(true);
		groupboxIdentificacaoDoFuncionario.setVisible(false);
		groupboxFormacao.setVisible(false);
		janelaProcurarFormacao.setVisible(false);
		adicionar.setVisible(true);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		instituicao.setConstraint(c);
		ano.setConstraint(c);
		curso.setConstraint(c);
		titulo.setConstraint(c);
		especializacao.setConstraint(c);
		cpfDoFuncionario.setConstraint(c);
		
		cpfDoFuncionario.setText("");
		instituicao.setText("");
		ano.setText("");
		curso.setText("");
		titulo.setText("");
		especializacao.setText("");
		
		cpfDoFuncionario.setConstraint("no empty, /[0-9]+/:Este campo não pode ser vazio! Preencha-o somente com números!");
		instituicao.setConstraint("no empty");
		ano.setConstraint("no empty, no negative, no zero");
		curso.setConstraint("no empty");
		titulo.setConstraint("no empty");
		especializacao.setConstraint("no empty");
		
		
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
				
				if(funcionarioEncontrado.getFuncao() == "Professor"){
					EspecializacaoFormacao.setVisible(true);
					listcellEspecializacao.setVisible(true);
				}else{
					EspecializacaoFormacao.setVisible(false);
					listcellEspecializacao.setVisible(false);
				}
				
				
				nomeFuncionario2.setValue(funcionarioEncontrado.getNome());
				funcaoFuncionario2.setValue(funcionarioEncontrado.getFuncao());
		
				groupboxIdentificacaoDoFuncionario2.setVisible(true);
		
				listModel = new ListModelList(Facade.getInstance().listarFormacaoFuncionario(funcionarioEncontrado.getId()));
				ListagemFormacao.setModel(listModel);
		
				groupboxListaDeFormacao.setVisible(true);
		
	    
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
	
	
	public void onClick$EditarFormacao() throws InterruptedException {
		if(groupboxListaDeFormacao.isVisible() && ListagemFormacao.getSelectedIndex()!=-1){
			
			janelaProcurarFormacao.setVisible(false);
			cadastroFormacao.setVisible(true);
			groupboxProcurarFuncionario.setVisible(false);
			groupboxIdentificacaoDoFuncionario.setVisible(false);
			groupboxFormacao.setVisible(true);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);
			
			formacao = (Formacao) ListagemFormacao.getModel().getElementAt(ListagemFormacao.getSelectedIndex());
			
			if(funcionarioEncontrado.getFuncao() == "Professor"){
				rowEspecializacao.setVisible(true);
				especializacao.setText(formacao.getEspecializacao());
				especializacao.setConstraint("no empty");
			}else{
				rowEspecializacao.setVisible(false);
			}
			
			
			instituicao.setText(formacao.getInstituicao());
			ano.setText(String.valueOf(formacao.getAnoConclusao()));
			curso.setText(formacao.getCurso());
			titulo.setText(formacao.getTitulo());
			
			instituicao.setConstraint("no empty");
			ano.setConstraint("no empty, no negative, no zero");
			curso.setConstraint("no empty");
			titulo.setConstraint("no empty");
			
			
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
		
		Formacao f = Facade.getInstance().carregarFormacao(((Formacao)ListagemFormacao.getModel().getElementAt(ListagemFormacao.getSelectedIndex())).getId());
		
		if(funcionarioEncontrado.getFuncao() == "Professor"){
			f.setEspecializacao(especializacao.getValue());
		}
		
		f.setTitulo(titulo.getValue());
		f.setCurso(curso.getValue());
		f.setInstituicao(instituicao.getValue());
		f.setAnoConclusao(ano.getValue());
		
		Facade.getInstance().atualizarFormacao(f);
		
		cadastroFormacao.setVisible(false);
		janelaProcurarFormacao.setVisible(false);
		
		listModel = new ListModelList(Facade.getInstance().listarFormacaoFuncionario(funcionarioEncontrado.getId()));
		ListagemFormacao.setModel(listModel);
		
		Messagebox.show("Formação Alterado com Sucesso!",
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
		cadastroFormacao.setVisible(false);
		janelaProcurarFormacao.setVisible(false);
	}

				
	public void onClick$DeletarFormacao(Event event) throws InterruptedException {  
		if(groupboxListaDeFormacao.isVisible() && ListagemFormacao.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar a Formação selecionada?",
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
		Facade.getInstance().removerFormacao(((Formacao) ListagemFormacao.getModel().getElementAt(ListagemFormacao.getSelectedIndex())).getId());
		
		listModel = new ListModelList(Facade.getInstance().listarFormacaoFuncionario(funcionarioEncontrado.getId()));
		ListagemFormacao.setModel(listModel);
	}

}
