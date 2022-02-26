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
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.dto.FichaClinicaDto;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.Ficha_ClinicaService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value="MBFichaClinica")
@ViewScoped
public class FichaClinicaBean {
	
	private FichaClinicaDto FichaClinica;
	private ArrayList<FichaClinicaDto> itens;
	private String nomeBusca;
	
	private UploadedFile file;
	
	
	@Autowired
	private Ficha_ClinicaService fichaService;
	
   
	
	public FichaClinicaBean() {
		this.FichaClinica = new FichaClinicaDto(); 
		this.fichaService = new Ficha_ClinicaService();
		
	}
    
	
	
	
	
	public UploadedFile getFile() {
		return file;
	}





	public void setFile(UploadedFile file) {
		this.file = file;
	}





	public FichaClinicaDto getFichaClinica() {
		return FichaClinica;
	}



	public Ficha_ClinicaService getFichaService() {
		return fichaService;
	}

	public void setFichaService(Ficha_ClinicaService fichaService) {
		this.fichaService = fichaService;
	}

	public void setFichaClinica(FichaClinicaDto fichaClinica) {
		FichaClinica = fichaClinica;
	}



	public ArrayList<FichaClinicaDto> getItens() {
		return itens;
	}



	public void setItens(ArrayList<FichaClinicaDto> itens) {
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
		itens = new ArrayList<FichaClinicaDto>(this.fichaService.listarFichas().getBody().getFicha_clinica());
	}
	

	public void cadastrar() {
		
		Random n1 = new Random();
		
		this.FichaClinica.setId(n1.nextInt(1000000000));
		
		LocalDate data = LocalDate.now();
		
		String converterData = String.valueOf(data);
		this.FichaClinica.setData_registro_animal(converterData);
		
		
		Boolean validacao = this.fichaService.salvarFicha(this.FichaClinica, this.FichaClinica.getEmail());

		if(validacao == true) {
			String nomeAnimalMaiusculo = this.FichaClinica.getNomeAnimal().toUpperCase();
			JsfUtil.adicionarMensagemDeSucesso(nomeAnimalMaiusculo +  " FOI CADASTRADO(A) COM SUCESSO", null);
			this.FichaClinica = new FichaClinicaDto();


		}else if( validacao == false) {
			
			JsfUtil.adicionarMensagemDeErro("ESTE E-MAIL J� EST� CADASTRADO NO SISTEMA", null);
		}
		this.FichaClinica = new FichaClinicaDto(); 
		listar();
	}
	public void excluir() {
		this.fichaService.excluir(this.FichaClinica.getId());
		JsfUtil.adicionarMensagemDeSucesso("FICHA DELETADA COM SUCESSO", null);
		this.FichaClinica = new FichaClinicaDto(); 
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
		this.FichaClinica = new FichaClinicaDto(); 
		listar();

	}
	public void buscarNome() {
		List<FichaClinicaDto> lista = this.fichaService.listarFichasPorNomeAnimal(nomeBusca).getBody().getFicha_clinica();
		
		itens = new ArrayList<FichaClinicaDto>(lista);
		JsfUtil.adicionarMensagemDeSucesso("AQUI EST�O OS RESULTADOS ENCONTRADOS: ", null);
		this.FichaClinica = new FichaClinicaDto(); 
		setNomeBusca(null);
		
	}
	
	public void listarTodos() {
		
		List<FichaClinicaDto> lista = this.fichaService.listarFichas().getBody().getFicha_clinica();

		itens = new ArrayList<FichaClinicaDto>(lista);
		JsfUtil.adicionarMensagemDeSucesso("CONSULTA RESETADA ", null);
		this.FichaClinica = new FichaClinicaDto(); 
		setNomeBusca(null);


	}
	
	public void direcionar() throws IOException {
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/pages/upload.xhtml");	
		}
	
	public void printar() {
		System.out.println(this.file.getFileName());
	}
	
	public List<String> completarCodigoBarras(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        List<FichaClinicaDto> produtos = this.fichaService.listarFichas().getBody().getFicha_clinica();
        for (FichaClinicaDto produto : produtos) {
            countryList.add(produto.getNomeAnimal());
        }

        return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
	public void upload(FileUploadEvent evento) {
		System.out.println("entroooou");
	}
}
