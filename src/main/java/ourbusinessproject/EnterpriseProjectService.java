package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private final EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project findProjectById(Long projectId) {
        return entityManager.find(Project.class, projectId);
    }

    public Enterprise findEnterpriseById(Long entrepriseId) {
        return entityManager.find(Enterprise.class, entrepriseId);
    }

    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String mail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactName(aContactName);
        enterprise.setContactEmail(mail);

        entityManager.persist(enterprise);
        entityManager.flush();

        return enterprise;
    }

    public Project newProject(String aTitle, String aDescription, Enterprise aEnterprise) {
        Project project = new Project();

        project.setTitle(aTitle);
        project.setDescription(aDescription);
        project.setEnterprise(aEnterprise);

        entityManager.persist(project);
        entityManager.flush();

        aEnterprise.addProject(project);
        return project;
    }

    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> queryObj =  entityManager.createQuery(query, Project.class);
        return queryObj.getResultList();
    }
}
