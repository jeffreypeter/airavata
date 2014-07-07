package org.apache.aiaravata.application.catalog.data.resources;

import org.airavata.appcatalog.cpi.AppCatalogException;
import org.apache.aiaravata.application.catalog.data.model.ScpDataMovement;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogJPAUtils;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogQueryGenerator;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogResourceType;
import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ScpDataMovementResource extends AbstractResource {
	private final static Logger logger = LoggerFactory.getLogger(ScpDataMovementResource.class);
	private String queueDescription;
	private String dataMovementInterfaceId;
	private String securityProtocol;
	private String alternativeScpHostname;
	private int sshPort;
	
	@Override
	public void remove(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(SCP_DATA_MOVEMENT);
			generator.setParameter(ScpDataMovementConstants.DATA_MOVEMENT_INTERFACE_ID, identifier);
			Query q = generator.deleteQuery(em);
			q.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public Resource get(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(SCP_DATA_MOVEMENT);
			generator.setParameter(ScpDataMovementConstants.DATA_MOVEMENT_INTERFACE_ID, identifier);
			Query q = generator.selectQuery(em);
			ScpDataMovement scpDataMovement = (ScpDataMovement) q.getSingleResult();
			ScpDataMovementResource scpDataMovementResource = (ScpDataMovementResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.SCP_DATA_MOVEMENT, scpDataMovement);
			em.getTransaction().commit();
			em.close();
			return scpDataMovementResource;
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public List<Resource> get(String fieldName, Object value) throws AppCatalogException {
		List<Resource> scpDataMovementResources = new ArrayList<Resource>();
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(SCP_DATA_MOVEMENT);
			Query q;
			if ((fieldName.equals(ScpDataMovementConstants.QUEUE_DESCRIPTION)) || (fieldName.equals(ScpDataMovementConstants.DATA_MOVEMENT_INTERFACE_ID)) || (fieldName.equals(ScpDataMovementConstants.SECURITY_PROTOCOL)) || (fieldName.equals(ScpDataMovementConstants.ALTERNATIVE_SCP_HOSTNAME)) || (fieldName.equals(ScpDataMovementConstants.SSH_PORT))) {
				generator.setParameter(fieldName, value);
				q = generator.selectQuery(em);
				List<?> results = q.getResultList();
				for (Object result : results) {
					ScpDataMovement scpDataMovement = (ScpDataMovement) result;
					ScpDataMovementResource scpDataMovementResource = (ScpDataMovementResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.SCP_DATA_MOVEMENT, scpDataMovement);
					scpDataMovementResources.add(scpDataMovementResource);
				}
			} else {
				em.getTransaction().commit();
					em.close();
				logger.error("Unsupported field name for Scp Data Movement Resource.", new IllegalArgumentException());
				throw new IllegalArgumentException("Unsupported field name for Scp Data Movement Resource.");
			}
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
		return scpDataMovementResources;
	}
	
	@Override
	public List<String> getIds(String fieldName, Object value) throws AppCatalogException {
		List<String> scpDataMovementResourceIDs = new ArrayList<String>();
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(SCP_DATA_MOVEMENT);
			Query q;
			if ((fieldName.equals(ScpDataMovementConstants.QUEUE_DESCRIPTION)) || (fieldName.equals(ScpDataMovementConstants.DATA_MOVEMENT_INTERFACE_ID)) || (fieldName.equals(ScpDataMovementConstants.SECURITY_PROTOCOL)) || (fieldName.equals(ScpDataMovementConstants.ALTERNATIVE_SCP_HOSTNAME)) || (fieldName.equals(ScpDataMovementConstants.SSH_PORT))) {
				generator.setParameter(fieldName, value);
				q = generator.selectQuery(em);
				List<?> results = q.getResultList();
				for (Object result : results) {
					ScpDataMovement scpDataMovement = (ScpDataMovement) result;
					ScpDataMovementResource scpDataMovementResource = (ScpDataMovementResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.SCP_DATA_MOVEMENT, scpDataMovement);
					scpDataMovementResourceIDs.add(scpDataMovementResource.getDataMovementInterfaceId());
				}
			} else {
				em.getTransaction().commit();
					em.close();
				logger.error("Unsupported field name for Scp Data Movement Resource.", new IllegalArgumentException());
				throw new IllegalArgumentException("Unsupported field name for Scp Data Movement Resource.");
			}
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
		return scpDataMovementResourceIDs;
	}
	
	@Override
	public void save() throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			ScpDataMovement existingScpDataMovement = em.find(ScpDataMovement.class, dataMovementInterfaceId);
			em.close();
			ScpDataMovement scpDataMovement;
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			if (existingScpDataMovement == null) {
				scpDataMovement = new ScpDataMovement();
			} else {
				scpDataMovement = existingScpDataMovement;
			}
			scpDataMovement.setQueueDescription(getQueueDescription());
			scpDataMovement.setDataMovementInterfaceId(getDataMovementInterfaceId());
			scpDataMovement.setSecurityProtocol(getSecurityProtocol());
			scpDataMovement.setAlternativeScpHostname(getAlternativeScpHostname());
			scpDataMovement.setSshPort(getSshPort());
			if (existingScpDataMovement == null) {
				em.persist(scpDataMovement);
			} else {
				em.merge(scpDataMovement);
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public boolean isExists(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			ScpDataMovement scpDataMovement = em.find(ScpDataMovement.class, identifier);
			em.close();
			return scpDataMovement != null;
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	public String getQueueDescription() {
		return queueDescription;
	}
	
	public String getDataMovementInterfaceId() {
		return dataMovementInterfaceId;
	}
	
	public String getSecurityProtocol() {
		return securityProtocol;
	}
	
	public String getAlternativeScpHostname() {
		return alternativeScpHostname;
	}
	
	public int getSshPort() {
		return sshPort;
	}
	
	public void setQueueDescription(String queueDescription) {
		this.queueDescription=queueDescription;
	}
	
	public void setDataMovementInterfaceId(String dataMovementInterfaceId) {
		this.dataMovementInterfaceId=dataMovementInterfaceId;
	}
	
	public void setSecurityProtocol(String securityProtocol) {
		this.securityProtocol=securityProtocol;
	}
	
	public void setAlternativeScpHostname(String alternativeScpHostname) {
		this.alternativeScpHostname=alternativeScpHostname;
	}
	
	public void setSshPort(int sshPort) {
		this.sshPort=sshPort;
	}
}