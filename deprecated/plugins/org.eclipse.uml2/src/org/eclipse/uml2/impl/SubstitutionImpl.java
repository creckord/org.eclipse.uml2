/*
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: SubstitutionImpl.java,v 1.27 2006/05/26 18:16:43 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.Classifier;
import org.eclipse.uml2.Component;
//import org.eclipse.uml2.Element;
import org.eclipse.uml2.NamedElement;
import org.eclipse.uml2.OpaqueExpression;
import org.eclipse.uml2.StringExpression;
import org.eclipse.uml2.Substitution;
import org.eclipse.uml2.TemplateParameter;
import org.eclipse.uml2.TemplateSignature;
import org.eclipse.uml2.UML2Package;
import org.eclipse.uml2.VisibilityKind;

//import org.eclipse.uml2.common.util.CacheAdapter;
//import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectResolvingEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectWithInverseResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getTargets <em>Target</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getSources <em>Source</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getSuppliers <em>Supplier</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getClients <em>Client</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.SubstitutionImpl#getSubstitutingClassifier <em>Substituting Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstitutionImpl extends RealizationImpl implements Substitution {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getContract() <em>Contract</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContract()
	 * @generated
	 * @ordered
	 */
	protected Classifier contract = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTargets() {
		return super.getTargets();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargets() {
		return super.isSetTargets()
			|| eIsSet(UML2Package.SUBSTITUTION__CONTRACT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getSources() {
		return super.getSources();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSources() {
		return super.isSetSources()
			|| eIsSet(UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getContract() {
		if (contract != null && contract.eIsProxy()) {
			InternalEObject oldContract = (InternalEObject)contract;
			contract = (Classifier)eResolveProxy(oldContract);
			if (contract != oldContract) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.SUBSTITUTION__CONTRACT, oldContract, contract));
			}
		}
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetContract() {
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContract(Classifier newContract) {
		Classifier oldContract = contract;
		contract = newContract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.SUBSTITUTION__CONTRACT, oldContract, contract));


		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newContract != null) {
				EList suppliers = getSuppliers();
				if (!suppliers.contains(newContract)) {
					suppliers.add(newContract);
				}
			}
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getSubstitutingClassifier() {
		if (eContainerFeatureID != UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER) return null;
		return (Classifier)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubstitutingClassifier(Classifier newSubstitutingClassifier, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSubstitutingClassifier, UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER, msgs);

		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newSubstitutingClassifier != null) {
				EList clients = getClients();
				if (!clients.contains(newSubstitutingClassifier)) {
					clients.add(newSubstitutingClassifier);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstitutingClassifier(Classifier newSubstitutingClassifier) {
		if (newSubstitutingClassifier != eInternalContainer() || (eContainerFeatureID != UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER && newSubstitutingClassifier != null)) {
			if (EcoreUtil.isAncestor(this, newSubstitutingClassifier))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSubstitutingClassifier != null)
				msgs = ((InternalEObject)newSubstitutingClassifier).eInverseAdd(this, UML2Package.CLASSIFIER__SUBSTITUTION, Classifier.class, msgs);
			msgs = basicSetSubstitutingClassifier(newSubstitutingClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER, newSubstitutingClassifier, newSubstitutingClassifier));

	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicAdd(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignature)otherEnd, msgs);
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicAdd(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningParameter((TemplateParameter)otherEnd, msgs);
			case UML2Package.SUBSTITUTION__CLIENT:
				return ((InternalEList)getClients()).basicAdd(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAbstraction((Component)otherEnd, msgs);
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSubstitutingClassifier((Classifier)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				return ((InternalEList)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				return ((InternalEList)getClientDependencies()).basicRemove(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__NAME_EXPRESSION:
				return basicSetNameExpression(null, msgs);
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				return basicSetOwningParameter(null, msgs);
			case UML2Package.SUBSTITUTION__CLIENT:
				return ((InternalEList)getClients()).basicRemove(otherEnd, msgs);
			case UML2Package.SUBSTITUTION__MAPPING:
				return basicSetMapping(null, msgs);
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				return basicSetAbstraction(null, msgs);
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				return basicSetSubstitutingClassifier(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				return eInternalContainer().eInverseRemove(this, UML2Package.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				return eInternalContainer().eInverseRemove(this, UML2Package.COMPONENT__REALIZATION, Component.class, msgs);
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				return eInternalContainer().eInverseRemove(this, UML2Package.CLASSIFIER__SUBSTITUTION, Classifier.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuppliers() {
		if (suppliers == null) {
			suppliers = new SubsetSupersetEObjectResolvingEList(NamedElement.class, this, UML2Package.SUBSTITUTION__SUPPLIER, null, SUPPLIER_ESUBSETS);
		}
		return suppliers;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClients() {
		if (clients == null) {
			clients = new SubsetSupersetEObjectWithInverseResolvingEList.ManyInverse(NamedElement.class, this, UML2Package.SUBSTITUTION__CLIENT, null, CLIENT_ESUBSETS, UML2Package.NAMED_ELEMENT__CLIENT_DEPENDENCY);
		}
		return clients;
	}


	/**
	 * The array of subset feature identifiers for the '{@link #getTargets() <em>Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected static final int[] TARGET_ESUBSETS = new int[] {UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER, UML2Package.SUBSTITUTION__CONTRACT};

	/**
	 * The array of subset feature identifiers for the '{@link #getSources() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected static final int[] SOURCE_ESUBSETS = new int[] {UML2Package.SUBSTITUTION__ABSTRACTION, UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER};

	/**
	 * The array of subset feature identifiers for the '{@link #getSuppliers() <em>Supplier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] SUPPLIER_ESUBSETS = new int[] {UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER, UML2Package.SUBSTITUTION__CONTRACT};

	/**
	 * The array of subset feature identifiers for the '{@link #getClients() <em>Client</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClients()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLIENT_ESUBSETS = new int[] {UML2Package.SUBSTITUTION__ABSTRACTION, UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.SUBSTITUTION__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.SUBSTITUTION__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.SUBSTITUTION__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.SUBSTITUTION__NAME:
				return getName();
			case UML2Package.SUBSTITUTION__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.SUBSTITUTION__VISIBILITY:
				return getVisibility();
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.SUBSTITUTION__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.SUBSTITUTION__PACKAGEABLE_ELEMENT_VISIBILITY:
				return getPackageableElement_visibility();
			case UML2Package.SUBSTITUTION__RELATED_ELEMENT:
				return getRelatedElements();
			case UML2Package.SUBSTITUTION__SOURCE:
				return getSources();
			case UML2Package.SUBSTITUTION__TARGET:
				return getTargets();
			case UML2Package.SUBSTITUTION__CLIENT:
				return getClients();
			case UML2Package.SUBSTITUTION__SUPPLIER:
				return getSuppliers();
			case UML2Package.SUBSTITUTION__MAPPING:
				return getMapping();
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				return getAbstraction();
			case UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER:
				if (resolve) return getRealizingClassifier();
				return basicGetRealizingClassifier();
			case UML2Package.SUBSTITUTION__CONTRACT:
				if (resolve) return getContract();
				return basicGetContract();
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				return getSubstitutingClassifier();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case UML2Package.SUBSTITUTION__NAME:
				setName((String)newValue);
				return;
			case UML2Package.SUBSTITUTION__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)newValue);
				return;
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)newValue);
				return;
			case UML2Package.SUBSTITUTION__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility((VisibilityKind)newValue);
				return;
			case UML2Package.SUBSTITUTION__CLIENT:
				getClients().clear();
				getClients().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__SUPPLIER:
				getSuppliers().clear();
				getSuppliers().addAll((Collection)newValue);
				return;
			case UML2Package.SUBSTITUTION__MAPPING:
				setMapping((OpaqueExpression)newValue);
				return;
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				setAbstraction((Component)newValue);
				return;
			case UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER:
				setRealizingClassifier((Classifier)newValue);
				return;
			case UML2Package.SUBSTITUTION__CONTRACT:
				setContract((Classifier)newValue);
				return;
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				setSubstitutingClassifier((Classifier)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.SUBSTITUTION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case UML2Package.SUBSTITUTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2Package.SUBSTITUTION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				getClientDependencies().clear();
				return;
			case UML2Package.SUBSTITUTION__NAME_EXPRESSION:
				setNameExpression((StringExpression)null);
				return;
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				setOwningParameter((TemplateParameter)null);
				return;
			case UML2Package.SUBSTITUTION__PACKAGEABLE_ELEMENT_VISIBILITY:
				setPackageableElement_visibility(PACKAGEABLE_ELEMENT_VISIBILITY_EDEFAULT);
				return;
			case UML2Package.SUBSTITUTION__CLIENT:
				getClients().clear();
				return;
			case UML2Package.SUBSTITUTION__SUPPLIER:
				getSuppliers().clear();
				return;
			case UML2Package.SUBSTITUTION__MAPPING:
				setMapping((OpaqueExpression)null);
				return;
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				setAbstraction((Component)null);
				return;
			case UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER:
				setRealizingClassifier((Classifier)null);
				return;
			case UML2Package.SUBSTITUTION__CONTRACT:
				setContract((Classifier)null);
				return;
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				setSubstitutingClassifier((Classifier)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UML2Package.SUBSTITUTION__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.SUBSTITUTION__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.SUBSTITUTION__OWNER:
				return isSetOwner();
			case UML2Package.SUBSTITUTION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.SUBSTITUTION__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.SUBSTITUTION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.SUBSTITUTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.SUBSTITUTION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.SUBSTITUTION__VISIBILITY:
				return isSetVisibility();
			case UML2Package.SUBSTITUTION__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.SUBSTITUTION__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.SUBSTITUTION__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.SUBSTITUTION__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.SUBSTITUTION__PACKAGEABLE_ELEMENT_VISIBILITY:
				return isSetPackageableElement_visibility();
			case UML2Package.SUBSTITUTION__RELATED_ELEMENT:
				return isSetRelatedElements();
			case UML2Package.SUBSTITUTION__SOURCE:
				return isSetSources();
			case UML2Package.SUBSTITUTION__TARGET:
				return isSetTargets();
			case UML2Package.SUBSTITUTION__CLIENT:
				return clients != null && !clients.isEmpty();
			case UML2Package.SUBSTITUTION__SUPPLIER:
				return suppliers != null && !suppliers.isEmpty();
			case UML2Package.SUBSTITUTION__MAPPING:
				return mapping != null;
			case UML2Package.SUBSTITUTION__ABSTRACTION:
				return getAbstraction() != null;
			case UML2Package.SUBSTITUTION__REALIZING_CLASSIFIER:
				return realizingClassifier != null;
			case UML2Package.SUBSTITUTION__CONTRACT:
				return contract != null;
			case UML2Package.SUBSTITUTION__SUBSTITUTING_CLASSIFIER:
				return getSubstitutingClassifier() != null;
		}
		return eDynamicIsSet(featureID);
	}


} //SubstitutionImpl
