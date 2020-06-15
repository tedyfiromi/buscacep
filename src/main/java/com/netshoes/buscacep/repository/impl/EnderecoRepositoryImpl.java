package com.netshoes.buscacep.repository.impl;

import com.netshoes.buscacep.model.Endereco;
import com.netshoes.buscacep.repository.EnderecoRepository;
import com.netshoes.buscacep.service.impl.EnderecoServiceImpl;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.Iterator;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    @Value("${url.cep}")
    private String baseUrlCep;

    private Endereco endereco;

    private Logger LOG = Logger.getLogger(EnderecoServiceImpl.class);


    @Override
    public Endereco buscaEnderecoPorCep(String cep) {
        try {

            endereco = new Endereco();

            URL url = new URL( baseUrlCep + procuraCepValido(cep) + "&formato=xml");

            Document document = getDocumento(url);
            Element root = document.getRootElement();

            for (Iterator i = root.elementIterator(); i.hasNext(); ) {

                Element element = (Element) i.next();

                if (element.getQualifiedName().equals("uf")) endereco.setUf(element.getText());
                if (element.getQualifiedName().equals("cidade")) endereco.setCidade(element.getText());
                if (element.getQualifiedName().equals("bairro")) endereco.setBairro(element.getText());
                if (element.getQualifiedName().equals("tipo_logradouro")) endereco.setTipoLogradouro(element.getText());
                if (element.getQualifiedName().equals("logradouro")) endereco.setLogradouro(element.getText());
                if (element.getQualifiedName().equals("resultado")) endereco.setResultado(Integer.valueOf(element.getText()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return endereco;
    }

    @Override
    public String procuraCepValido(String cep) {

        int i = 7;
        while (!cepValido(cep)) {
            StringBuilder newCep = new StringBuilder(cep);
            newCep.setCharAt(i--, '0');

            if (i == 3) {
                break;
            }

            cep = newCep.toString();

            LOG.info("Cep consultado: " + cep);
        }
        return cep;
    }

    public boolean cepValido(String cep) {
        System.out.println(cep);
        try {
            URL url = new URL(baseUrlCep + cep + "&formato=xml");

            Document document = getDocumento(url);
            Element root = document.getRootElement();

            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();

                if (element.getQualifiedName().equals("resultado")) return element.getText().equals("1");

            }


        } catch (Exception e) {
            e.getStackTrace();
        }

        return false;
    }

    private Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

}
