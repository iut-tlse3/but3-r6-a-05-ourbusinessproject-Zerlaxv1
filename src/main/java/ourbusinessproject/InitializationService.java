package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private Project project1e1;
    private Project project2e1;
    private Project project1e2;
    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Transactional
    public void initProjects() {
        enterprise1 = enterpriseProjectService.newEnterprise("a kylian Corp", "ici on fait plein de truc gratuit !!", "Kylian Pawilowski", "kylianLeSuperBg@gmail.com");
        enterprise2 = enterpriseProjectService.newEnterprise("b allan inc.", "pro a league of legends", "Allan Fabre", "allanFabreChouBidouALaCreme@gmail.com");

        project1e1 = enterpriseProjectService.newProject("a don d'eau !!", "entreprise de don d'eau de kylian", enterprise1);
        project1e2 = enterpriseProjectService.newProject("b spotify", "écoutez de la musique avec la nouvelle application de kylian corp !", enterprise2);
        project2e1 = enterpriseProjectService.newProject("c formation challenger+ allan", "assistez gratuitement a la formation challenger de allan", enterprise1);
    }

    public Project getProject1E1() {
        return this.project1e1;
    }

    public Project getProject1E2() {
        return this.project1e2;
    }

    public Project getProject2E1() {
        return this.project2e1;
    }

    public Enterprise getEnterprise1() {
        return this.enterprise1;
    }

    public Enterprise getEnterprise2() {
        return this.enterprise2;
    }
}
