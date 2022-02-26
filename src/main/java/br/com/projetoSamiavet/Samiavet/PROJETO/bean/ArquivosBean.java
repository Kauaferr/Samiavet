package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosCT;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosES;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosFU;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosGeral;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosImagens;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosRX;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosSV;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosUS;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivoGeralService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ArquivosImagensService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.CTService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ESService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.FUService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.RXService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.SVService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.USService;

@Named(value="arquivosBean")
@ViewScoped
@RestController
public class ArquivosBean {

	
	private ArquivosGeral arquivosGeral;
	
	private ArquivosES arquivosES;
	
	private ArquivosSV arquivosSV;
	
	private ArquivosUS arquivosUS;
	
	private ArquivosFU arquivosFU;
	
	private ArquivosRX arquivosRX;
	
	private ArquivosCT arquivosCT;
	
	private ArquivosImagens arquivoImagem;
	
	private StreamedContent fileArquivosGeral;
	
	private StreamedContent fileArquivosES;

	private StreamedContent fileArquivosSV;
	
	private StreamedContent fileArquivosUS;

	private StreamedContent fileArquivosFU;

	private StreamedContent fileArquivosRX;

	private StreamedContent fileArquivosCT;
	
	private StreamedContent fileArquivosImagens;

	private List<ArquivosES> listaES;
	
	private List<ArquivosSV> listaSV;
	
	private List<ArquivosUS> listaUS;
	
	private List<ArquivosFU> listaFU;
	
	private List<ArquivosRX> listaRX;
	
	private List<ArquivosCT> listaCT;
	
	private List<ArquivosGeral> listaArquivosGeral;
	
	private List<ArquivosImagens> listaArquivoImagens;
	
	
	@Autowired
	private ArquivoGeralService arquivoService;
	
	@Autowired
	private ESService esService;
	
	@Autowired
	private SVService svService;
	
	@Autowired
	private USService usService;
	
	@Autowired
	private FUService fuService;

	@Autowired
	private RXService rxService;
	
	@Autowired
	private CTService ctService;
	
	@Autowired
	private ArquivosImagensService imagensService;
	
	public ArquivosBean() {
		this.arquivosGeral = new ArquivosGeral();
		this.arquivosCT = new ArquivosCT();
		this.arquivosES = new ArquivosES();
		this.arquivosFU = new ArquivosFU();
		this.arquivosRX = new ArquivosRX();
		this.arquivosUS = new ArquivosUS();
		this.arquivosSV = new ArquivosSV();
		this.arquivoImagem = new ArquivosImagens();
		
	}

	
	public ArquivosGeral getArquivosGeral() {
		return arquivosGeral;
	}


	public void setArquivosGeral(ArquivosGeral arquivosGeral) {
		this.arquivosGeral = arquivosGeral;
	}

	
	public ArquivosES getArquivosES() {
		return arquivosES;
	}


	public void setArquivosES(ArquivosES arquivosES) {
		this.arquivosES = arquivosES;
	}


	public ArquivosSV getArquivosSV() {
		return arquivosSV;
	}


	public void setArquivosSV(ArquivosSV arquivosSV) {
		this.arquivosSV = arquivosSV;
	}


	public ArquivosUS getArquivosUS() {
		return arquivosUS;
	}


	public void setArquivosUS(ArquivosUS arquivosUS) {
		this.arquivosUS = arquivosUS;
	}


	public ArquivosFU getArquivosFU() {
		return arquivosFU;
	}


	public void setArquivosFU(ArquivosFU arquivosFU) {
		this.arquivosFU = arquivosFU;
	}


	public ArquivosRX getArquivosRX() {
		return arquivosRX;
	}


	public void setArquivosRX(ArquivosRX arquivosRX) {
		this.arquivosRX = arquivosRX;
	}


	public ArquivosCT getArquivosCT() {
		return arquivosCT;
	}


	public void setArquivosCT(ArquivosCT arquivosCT) {
		this.arquivosCT = arquivosCT;
	}


	public List<ArquivosES> getListaES() {
		return listaES;
	}


	public void setListaES(List<ArquivosES> listaES) {
		this.listaES = listaES;
	}


	public List<ArquivosSV> getListaSV() {
		return listaSV;
	}


	public void setListaSV(List<ArquivosSV> listaSV) {
		this.listaSV = listaSV;
	}


	public List<ArquivosUS> getListaUS() {
		return listaUS;
	}


	public void setListaUS(List<ArquivosUS> listaUS) {
		this.listaUS = listaUS;
	}


	public List<ArquivosFU> getListaFU() {
		return listaFU;
	}


	public void setListaFU(List<ArquivosFU> listaFU) {
		this.listaFU = listaFU;
	}


	public List<ArquivosRX> getListaRX() {
		return listaRX;
	}


	public void setListaRX(List<ArquivosRX> listaRX) {
		this.listaRX = listaRX;
	}


	public List<ArquivosCT> getListaCT() {
		return listaCT;
	}


	public void setListaCT(List<ArquivosCT> listaCT) {
		this.listaCT = listaCT;
	}


	public ArquivoGeralService getArquivoService() {
		return arquivoService;
	}


	public void setArquivoService(ArquivoGeralService arquivoService) {
		this.arquivoService = arquivoService;
	}


	public ESService getEsService() {
		return esService;
	}


	public void setEsService(ESService esService) {
		this.esService = esService;
	}


	public SVService getSvService() {
		return svService;
	}


	public void setSvService(SVService svService) {
		this.svService = svService;
	}


	public USService getUsService() {
		return usService;
	}


	public void setUsService(USService usService) {
		this.usService = usService;
	}


	public FUService getFuService() {
		return fuService;
	}


	public void setFuService(FUService fuService) {
		this.fuService = fuService;
	}


	public RXService getRxService() {
		return rxService;
	}


	public void setRxService(RXService rxService) {
		this.rxService = rxService;
	}


	public CTService getCtService() {
		return ctService;
	}


	public void setCtService(CTService ctService) {
		this.ctService = ctService;
	}


	public List<ArquivosGeral> getListaArquivosGeral() {
		return listaArquivosGeral;
	}


	public void setListaArquivosGeral(List<ArquivosGeral> listaArquivosGeral) {
		this.listaArquivosGeral = listaArquivosGeral;
	}

	
	public StreamedContent getFile() {
		return fileArquivosGeral;
	}


	public void setFile(StreamedContent file) {
		this.fileArquivosGeral = file;
	}

	
	public StreamedContent getFileArquivosGeral() {
		return fileArquivosGeral;
	}


	public void setFileArquivosGeral(StreamedContent fileArquivosGeral) {
		this.fileArquivosGeral = fileArquivosGeral;
	}


	public StreamedContent getFileArquivosES() {
		return fileArquivosES;
	}


	public void setFileArquivosES(StreamedContent fileArquivosES) {
		this.fileArquivosES = fileArquivosES;
	}


	public StreamedContent getFileArquivosSV() {
		return fileArquivosSV;
	}


	public void setFileArquivosSV(StreamedContent fileArquivosSV) {
		this.fileArquivosSV = fileArquivosSV;
	}


	public StreamedContent getFileArquivosUS() {
		return fileArquivosUS;
	}


	public void setFileArquivosUS(StreamedContent fileArquivosUS) {
		this.fileArquivosUS = fileArquivosUS;
	}


	public StreamedContent getFileArquivosFU() {
		return fileArquivosFU;
	}


	public void setFileArquivosFU(StreamedContent fileArquivosFU) {
		this.fileArquivosFU = fileArquivosFU;
	}


	public StreamedContent getFileArquivosRX() {
		return fileArquivosRX;
	}


	public void setFileArquivosRX(StreamedContent fileArquivosRX) {
		this.fileArquivosRX = fileArquivosRX;
	}


	public StreamedContent getFileArquivosCT() {
		return fileArquivosCT;
	}


	public void setFileArquivosCT(StreamedContent fileArquivosCT) {
		this.fileArquivosCT = fileArquivosCT;
	}

	
	
	public ArquivosImagens getArquivoImagem() {
		return arquivoImagem;
	}


	public void setArquivoImagem(ArquivosImagens arquivoImagem) {
		this.arquivoImagem = arquivoImagem;
	}


	public StreamedContent getFileArquivosImagens() {
		return fileArquivosImagens;
	}


	public void setFileArquivosImagens(StreamedContent fileArquivosImagens) {
		this.fileArquivosImagens = fileArquivosImagens;
	}


	public List<ArquivosImagens> getListaArquivoImagens() {
		return listaArquivoImagens;
	}


	public void setListaArquivoImagens(List<ArquivosImagens> listaArquivoImagens) {
		this.listaArquivoImagens = listaArquivoImagens;
	}


	public ArquivosImagensService getImagensService() {
		return imagensService;
	}


	public void setImagensService(ArquivosImagensService imagensService) {
		this.imagensService = imagensService;
	}


	@PostConstruct
	public void carregar() {
	
		this.listaCT = new ArrayList<ArquivosCT>(this.ctService.listar());
		this.listaES = new ArrayList<ArquivosES>(this.esService.listar());
		this.listaFU = new ArrayList<ArquivosFU>(this.fuService.listar());
		this.listaRX = new ArrayList<ArquivosRX>(this.rxService.listar());
		this.listaSV = new ArrayList<ArquivosSV>(this.svService.listar());
		this.listaUS = new ArrayList<ArquivosUS>(this.usService.listar());
		this.listaArquivosGeral = new ArrayList<ArquivosGeral>(this.arquivoService.listar());
		this.listaArquivoImagens = new ArrayList<ArquivosImagens>(this.imagensService.listar());
		
		
	
		

		
	}

	public void downloadArquivos() {
		

		 this.fileArquivosGeral = DefaultStreamedContent.builder()
	                .name(this.arquivosGeral.getNomeArquivo())
	                .contentType(this.arquivosGeral.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosGeral.getNomeArquivo()))
	                .build();
		
		 this.fileArquivosES = DefaultStreamedContent.builder()
	                .name(this.arquivosES.getNomeArquivo())
	                .contentType(this.arquivosES.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosES.getNomeArquivo()))
	                .build();
		 
		 
			
		 this.fileArquivosSV = DefaultStreamedContent.builder()
	                .name(this.arquivosSV.getNomeArquivo())
	                .contentType(this.arquivosSV.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosSV.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosUS = DefaultStreamedContent.builder()
	                .name(this.arquivosUS.getNomeArquivo())
	                .contentType(this.arquivosUS.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosUS.getNomeArquivo()))
	                .build();
		 
		 
		 this.fileArquivosFU = DefaultStreamedContent.builder()
	                .name(this.arquivosFU.getNomeArquivo())
	                .contentType(this.arquivosFU.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosFU.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosRX = DefaultStreamedContent.builder()
	                .name(this.arquivosRX.getNomeArquivo())
	                .contentType(this.arquivosRX.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosRX.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosCT = DefaultStreamedContent.builder()
	                .name(this.arquivosCT.getNomeArquivo())
	                .contentType(this.arquivosCT.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivosCT.getNomeArquivo()))
	                .build();
		 
		 this.fileArquivosImagens = DefaultStreamedContent.builder()
	                .name(this.arquivoImagem.getNomeImagem())
	                .contentType(this.arquivosCT.getTipoArquivo())
	                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/arquivos/" + this.arquivoImagem.getNomeImagem()))
	                .build();
	}
	
}
