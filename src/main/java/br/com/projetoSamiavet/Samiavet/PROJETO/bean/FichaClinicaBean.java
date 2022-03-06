package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.Ficha_ClinicaService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value="MBFichaClinica")
@ViewScoped
public class FichaClinicaBean {
	
	private FichaClinica FichaClinica;
	private ArrayList<FichaClinica> itens;
	private String nomeBusca;
	@Autowired
	private Ficha_ClinicaService fichaService;
	
   
	
	public FichaClinicaBean() {
		this.FichaClinica = new FichaClinica(); 
		this.fichaService = new Ficha_ClinicaService();
		
	}
    
	
	
	public FichaClinica getFichaClinica() {
		return FichaClinica;
	}



	public void setFichaClinica(FichaClinica fichaClinica) {
		FichaClinica = fichaClinica;
	}



	public ArrayList<FichaClinica> getItens() {
		return itens;
	}



	public void setItens(ArrayList<FichaClinica> itens) {
		this.itens = itens;
	}



	public String getNomeBusca() {
		return nomeBusca;
	}



	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}



	@PostConstruct
	public void listar() {
		itens = new ArrayList<FichaClinica>(this.fichaService.listar());
	}
	

	public void cadastrar() {
		
		Random n1 = new Random();
		
		
		
		LocalDate data = LocalDate.now();
		
		String converterData = String.valueOf(data);
		this.FichaClinica.setData_registro_animal(converterData);
		
		
		Boolean validacao = this.fichaService.salvarFicha(this.FichaClinica, this.FichaClinica.getEmail());

		if(validacao == true) {
			String nomeAnimalMaiusculo = this.FichaClinica.getNomeAnimal().toUpperCase();
			JsfUtil.adicionarMensagemDeSucesso(nomeAnimalMaiusculo +  " FOI CADASTRADO(A) COM SUCESSO", null);
			this.FichaClinica = new FichaClinica();


		}else if( validacao == false) {
			
			JsfUtil.adicionarMensagemDeErro("ESTE E-MAIL J� EST� CADASTRADO NO SISTEMA", null);
		}
		this.FichaClinica = new FichaClinica(); 
		listar();
	}
	public void excluir() {
		this.fichaService.excluir(this.FichaClinica.getId());
		JsfUtil.adicionarMensagemDeSucesso("FICHA DELETADA COM SUCESSO", null);
		this.FichaClinica = new FichaClinica(); 
		listar();
	}
	
	public void editar() {
		
		Boolean validacao = this.fichaService.editarFicha(this.FichaClinica, this.FichaClinica.getEmail());
		if(validacao == true) {
			JsfUtil.adicionarMensagemDeSucesso("FICHA EDITADA COM SUCESSO", null);
			listar();


		}else if( validacao == false) {
			
			JsfUtil.adicionarMensagemDeErro("ESTE E-MAIL J� EST� CADASTRADO NO SISTEMA", null);
		}
		this.FichaClinica = new FichaClinica(); 
		listar();

	}
	public void buscarNome() {
		List<FichaClinica> lista = this.fichaService.listarPorNome(this.nomeBusca);
		
		itens = new ArrayList<FichaClinica>(lista);
		JsfUtil.adicionarMensagemDeSucesso("AQUI EST�O OS RESULTADOS ENCONTRADOS: ", null);
		this.FichaClinica = new FichaClinica(); 
		setNomeBusca(null);
		
	}
	
	public void listarTodos() {
		
		List<FichaClinica> lista = this.fichaService.listar();

		itens = new ArrayList<FichaClinica>(lista);
		JsfUtil.adicionarMensagemDeSucesso("CONSULTA RESETADA ", null);
		this.FichaClinica = new FichaClinica(); 
		setNomeBusca(null);


	}
	
	public void direcionar() throws IOException {
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/pages/upload.xhtml");	
		}
	
	
	
	public List<String> completarCodigoBarras(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> listaNomes = new ArrayList<>();
        List<FichaClinica> nomes = this.fichaService.listar();
        for (FichaClinica nomesAnimais : nomes) {
        	listaNomes.add(nomesAnimais.getNomeAnimal());
        }

        return listaNomes.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
	public void upload(FileUploadEvent evento) {
		System.out.println("entroooou");
	}
	

}
