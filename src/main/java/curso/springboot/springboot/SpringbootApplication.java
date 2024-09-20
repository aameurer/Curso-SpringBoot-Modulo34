package curso.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "curso.springboot.springboot.model") // pra forçar o spring achar os pacotes
@ComponentScan(basePackages = {"curso.*"}) // pra forçar o spring achar os pacotes
@EnableJpaRepositories(basePackages = {"curso.springboot.springboot.repository"})
@EnableTransactionManagement
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		
		
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("123");
		System.out.println(result);*/

	}

}


// Criar Usuario
// INSERT INTO public.usuario(id, login, senha) VALUES (1, 'aam', '$2a$10$Xnjw09p8DffXlccIuqEV.OcmmdBGd71QrqmtLrvTAqiZIqa6rtky6');
// INSERT INTO public.usuario(id, login, senha) VALUES (2, 'teste', '$2a$10$Xnjw09p8DffXlccIuqEV.OcmmdBGd71QrqmtLrvTAqiZIqa6rtky6');

//INSERT INTO public.role(id, nome_role)	VALUES (1, 'ROLE_ADMIN');
//INSERT INTO public.role(id, nome_role)	VALUES (2, 'ROLE_USER');
//INSERT INTO public.role(id, nome_role)	VALUES (3, 'ROLE_GERENTE');
//INSERT INTO public.role(id, nome_role)	VALUES (4, 'ROLE_CAIXA');

//INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (1, 1);
//INSERT INTO public.usuarios_role(usuario_id, role_id)	VALUES (1, 4);
//INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (2, 2);
//INSERT INTO public.usuarios_role(usuario_id, role_id)	VALUES (2, 3);

// depois de criaedo mudar esta Role, para cadastrar usuario com o mesmo poder
// ALTER TABLE IF EXISTS public.usuarios_role ADD CONSTRAINT ukkrvk2qx218dxa3ogdyplk0wxw UNIQUE (role_id, usuario_id);