/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: CollaborationImpl.java,v 1.5 2005/11/28 20:26:03 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.eclipse.uml2.uml.internal.operations.StructuredClassifierOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getRoles <em>Role</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getAttributes <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getFeatures <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getOwnedAttributes <em>Owned Attribute</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getParts <em>Part</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getOwnedConnectors <em>Owned Connector</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.CollaborationImpl#getCollaborationRoles <em>Collaboration Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollaborationImpl
		extends BehavioredClassifierImpl
		implements Collaboration {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.COLLABORATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getRoles() {
		List role = (List) eVirtualGet(UMLPackage.COLLABORATION__ROLE);
		if (role == null) {
			eVirtualSet(UMLPackage.COLLABORATION__ROLE,
				role = new DerivedUnionEObjectEList(ConnectableElement.class,
					this, UMLPackage.COLLABORATION__ROLE, new int[]{
						UMLPackage.COLLABORATION__OWNED_ATTRIBUTE,
						UMLPackage.COLLABORATION__COLLABORATION_ROLE}));
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectableElement getRole(String name) {
		for (Iterator i = getRoles().iterator(); i.hasNext();) {
			ConnectableElement role = (ConnectableElement) i.next();
			if (name.equals(role.getName())) {
				return role;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedMembers() {
		List ownedMember = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_MEMBER);
		if (ownedMember == null) {
			eVirtualSet(UMLPackage.COLLABORATION__OWNED_MEMBER,
				ownedMember = new DerivedUnionEObjectEList(NamedElement.class,
					this, UMLPackage.COLLABORATION__OWNED_MEMBER, new int[]{
						UMLPackage.COLLABORATION__OWNED_RULE,
						UMLPackage.COLLABORATION__OWNED_USE_CASE,
						UMLPackage.COLLABORATION__OWNED_BEHAVIOR,
						UMLPackage.COLLABORATION__OWNED_TRIGGER,
						UMLPackage.COLLABORATION__OWNED_ATTRIBUTE,
						UMLPackage.COLLABORATION__OWNED_CONNECTOR}));
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getAttributes() {
		List attribute = (List) eVirtualGet(UMLPackage.COLLABORATION__ATTRIBUTE);
		if (attribute == null) {
			eVirtualSet(UMLPackage.COLLABORATION__ATTRIBUTE,
				attribute = new DerivedUnionEObjectEList(Property.class, this,
					UMLPackage.COLLABORATION__ATTRIBUTE,
					new int[]{UMLPackage.COLLABORATION__OWNED_ATTRIBUTE}));
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getMembers() {
		List member = (List) eVirtualGet(UMLPackage.COLLABORATION__MEMBER);
		if (member == null) {
			eVirtualSet(UMLPackage.COLLABORATION__MEMBER,
				member = new DerivedUnionEObjectEList(NamedElement.class, this,
					UMLPackage.COLLABORATION__MEMBER, new int[]{
						UMLPackage.COLLABORATION__IMPORTED_MEMBER,
						UMLPackage.COLLABORATION__OWNED_MEMBER,
						UMLPackage.COLLABORATION__FEATURE,
						UMLPackage.COLLABORATION__INHERITED_MEMBER,
						UMLPackage.COLLABORATION__ROLE}));
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getFeatures() {
		List feature = (List) eVirtualGet(UMLPackage.COLLABORATION__FEATURE);
		if (feature == null) {
			eVirtualSet(UMLPackage.COLLABORATION__FEATURE,
				feature = new DerivedUnionEObjectEList(Feature.class, this,
					UMLPackage.COLLABORATION__FEATURE, new int[]{
						UMLPackage.COLLABORATION__ATTRIBUTE,
						UMLPackage.COLLABORATION__OWNED_CONNECTOR}));
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedAttributes() {
		List ownedAttribute = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE);
		if (ownedAttribute == null) {
			eVirtualSet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE,
				ownedAttribute = new EObjectContainmentEList(Property.class,
					this, UMLPackage.COLLABORATION__OWNED_ATTRIBUTE));
		}
		return ownedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createOwnedAttribute(EClass eClass) {
		Property newOwnedAttribute = (Property) eClass.getEPackage()
			.getEFactoryInstance().create(eClass);
		getOwnedAttributes().add(newOwnedAttribute);
		return newOwnedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createOwnedAttribute() {
		Property newOwnedAttribute = UMLFactory.eINSTANCE.createProperty();
		getOwnedAttributes().add(newOwnedAttribute);
		return newOwnedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOwnedAttribute(String name) {
		for (Iterator i = getOwnedAttributes().iterator(); i.hasNext();) {
			Property ownedAttribute = (Property) i.next();
			if (name.equals(ownedAttribute.getName())) {
				return ownedAttribute;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getParts() {
		// TODO: implement this method to return the 'Part' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPart(String name) {
		for (Iterator i = getParts().iterator(); i.hasNext();) {
			Property part = (Property) i.next();
			if (name.equals(part.getName())) {
				return part;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOwnedConnectors() {
		List ownedConnector = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_CONNECTOR);
		if (ownedConnector == null) {
			eVirtualSet(UMLPackage.COLLABORATION__OWNED_CONNECTOR,
				ownedConnector = new EObjectContainmentEList(Connector.class,
					this, UMLPackage.COLLABORATION__OWNED_CONNECTOR));
		}
		return ownedConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createOwnedConnector() {
		Connector newOwnedConnector = UMLFactory.eINSTANCE.createConnector();
		getOwnedConnectors().add(newOwnedConnector);
		return newOwnedConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector getOwnedConnector(String name) {
		for (Iterator i = getOwnedConnectors().iterator(); i.hasNext();) {
			Connector ownedConnector = (Connector) i.next();
			if (name.equals(ownedConnector.getName())) {
				return ownedConnector;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getCollaborationRoles() {
		List collaborationRole = (List) eVirtualGet(UMLPackage.COLLABORATION__COLLABORATION_ROLE);
		if (collaborationRole == null) {
			eVirtualSet(UMLPackage.COLLABORATION__COLLABORATION_ROLE,
				collaborationRole = new EObjectResolvingEList(
					ConnectableElement.class, this,
					UMLPackage.COLLABORATION__COLLABORATION_ROLE));
		}
		return collaborationRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectableElement getCollaborationRole(String name) {
		for (Iterator i = getCollaborationRoles().iterator(); i.hasNext();) {
			ConnectableElement collaborationRole = (ConnectableElement) i
				.next();
			if (name.equals(collaborationRole.getName())) {
				return collaborationRole;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicities(DiagnosticChain diagnostics,
			Map context) {
		return StructuredClassifierOperations.validateMultiplicities(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.COLLABORATION__EANNOTATIONS :
				return ((InternalEList) getEAnnotations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_COMMENT :
				return ((InternalEList) getOwnedComments()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__CLIENT_DEPENDENCY :
				return ((InternalEList) getClientDependencies()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__NAME_EXPRESSION :
				return basicSetNameExpression(null, msgs);
			case UMLPackage.COLLABORATION__ELEMENT_IMPORT :
				return ((InternalEList) getElementImports()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__PACKAGE_IMPORT :
				return ((InternalEList) getPackageImports()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_RULE :
				return ((InternalEList) getOwnedRules()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.COLLABORATION__TEMPLATE_PARAMETER :
				return basicSetTemplateParameter(null, msgs);
			case UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER :
				return eBasicSetContainer(null,
					UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER, msgs);
			case UMLPackage.COLLABORATION__TEMPLATE_BINDING :
				return ((InternalEList) getTemplateBindings()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE :
				return basicSetOwnedTemplateSignature(null, msgs);
			case UMLPackage.COLLABORATION__GENERALIZATION :
				return ((InternalEList) getGeneralizations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__POWERTYPE_EXTENT :
				return ((InternalEList) getPowertypeExtents()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_USE_CASE :
				return ((InternalEList) getOwnedUseCases()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__USE_CASE :
				return ((InternalEList) getUseCases()).basicRemove(otherEnd,
					msgs);
			case UMLPackage.COLLABORATION__SUBSTITUTION :
				return ((InternalEList) getSubstitutions()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__COLLABORATION_USE :
				return ((InternalEList) getCollaborationUses()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_SIGNATURE :
				return basicSetOwnedSignature(null, msgs);
			case UMLPackage.COLLABORATION__OWNED_BEHAVIOR :
				return ((InternalEList) getOwnedBehaviors()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__INTERFACE_REALIZATION :
				return ((InternalEList) getInterfaceRealizations())
					.basicRemove(otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_TRIGGER :
				return ((InternalEList) getOwnedTriggers()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
				return ((InternalEList) getOwnedAttributes()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
				return ((InternalEList) getOwnedConnectors()).basicRemove(
					otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.COLLABORATION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.COLLABORATION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.COLLABORATION__OWNER :
				return getOwner();
			case UMLPackage.COLLABORATION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.COLLABORATION__NAME :
				return getName();
			case UMLPackage.COLLABORATION__VISIBILITY :
				return getVisibility();
			case UMLPackage.COLLABORATION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.COLLABORATION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.COLLABORATION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.COLLABORATION__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.COLLABORATION__ELEMENT_IMPORT :
				return getElementImports();
			case UMLPackage.COLLABORATION__PACKAGE_IMPORT :
				return getPackageImports();
			case UMLPackage.COLLABORATION__OWNED_RULE :
				return getOwnedRules();
			case UMLPackage.COLLABORATION__MEMBER :
				return getMembers();
			case UMLPackage.COLLABORATION__IMPORTED_MEMBER :
				return getImportedMembers();
			case UMLPackage.COLLABORATION__OWNED_MEMBER :
				return getOwnedMembers();
			case UMLPackage.COLLABORATION__IS_LEAF :
				return isLeaf()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.COLLABORATION__REDEFINED_ELEMENT :
				return getRedefinedElements();
			case UMLPackage.COLLABORATION__REDEFINITION_CONTEXT :
				return getRedefinitionContexts();
			case UMLPackage.COLLABORATION__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER :
				if (resolve)
					return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case UMLPackage.COLLABORATION__PACKAGE :
				return getPackage();
			case UMLPackage.COLLABORATION__TEMPLATE_BINDING :
				return getTemplateBindings();
			case UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE :
				return getOwnedTemplateSignature();
			case UMLPackage.COLLABORATION__IS_ABSTRACT :
				return isAbstract()
					? Boolean.TRUE
					: Boolean.FALSE;
			case UMLPackage.COLLABORATION__GENERALIZATION :
				return getGeneralizations();
			case UMLPackage.COLLABORATION__POWERTYPE_EXTENT :
				return getPowertypeExtents();
			case UMLPackage.COLLABORATION__FEATURE :
				return getFeatures();
			case UMLPackage.COLLABORATION__INHERITED_MEMBER :
				return getInheritedMembers();
			case UMLPackage.COLLABORATION__REDEFINED_CLASSIFIER :
				return getRedefinedClassifiers();
			case UMLPackage.COLLABORATION__GENERAL :
				return getGenerals();
			case UMLPackage.COLLABORATION__OWNED_USE_CASE :
				return getOwnedUseCases();
			case UMLPackage.COLLABORATION__USE_CASE :
				return getUseCases();
			case UMLPackage.COLLABORATION__SUBSTITUTION :
				return getSubstitutions();
			case UMLPackage.COLLABORATION__ATTRIBUTE :
				return getAttributes();
			case UMLPackage.COLLABORATION__REPRESENTATION :
				return getRepresentation();
			case UMLPackage.COLLABORATION__COLLABORATION_USE :
				return getCollaborationUses();
			case UMLPackage.COLLABORATION__OWNED_SIGNATURE :
				return getOwnedSignature();
			case UMLPackage.COLLABORATION__OWNED_BEHAVIOR :
				return getOwnedBehaviors();
			case UMLPackage.COLLABORATION__CLASSIFIER_BEHAVIOR :
				return getClassifierBehavior();
			case UMLPackage.COLLABORATION__INTERFACE_REALIZATION :
				return getInterfaceRealizations();
			case UMLPackage.COLLABORATION__OWNED_TRIGGER :
				return getOwnedTriggers();
			case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
				return getOwnedAttributes();
			case UMLPackage.COLLABORATION__PART :
				return getParts();
			case UMLPackage.COLLABORATION__ROLE :
				return getRoles();
			case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
				return getOwnedConnectors();
			case UMLPackage.COLLABORATION__COLLABORATION_ROLE :
				return getCollaborationRoles();
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
			case UMLPackage.COLLABORATION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.COLLABORATION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.COLLABORATION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.COLLABORATION__ELEMENT_IMPORT :
				getElementImports().clear();
				getElementImports().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__PACKAGE_IMPORT :
				getPackageImports().clear();
				getPackageImports().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_RULE :
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__IS_LEAF :
				setIsLeaf(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.COLLABORATION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.COLLABORATION__PACKAGE :
				setPackage((org.eclipse.uml2.uml.Package) newValue);
				return;
			case UMLPackage.COLLABORATION__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) newValue);
				return;
			case UMLPackage.COLLABORATION__IS_ABSTRACT :
				setIsAbstract(((Boolean) newValue).booleanValue());
				return;
			case UMLPackage.COLLABORATION__GENERALIZATION :
				getGeneralizations().clear();
				getGeneralizations().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__POWERTYPE_EXTENT :
				getPowertypeExtents().clear();
				getPowertypeExtents().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__INHERITED_MEMBER :
				getInheritedMembers().clear();
				getInheritedMembers().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__REDEFINED_CLASSIFIER :
				getRedefinedClassifiers().clear();
				getRedefinedClassifiers().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__GENERAL :
				getGenerals().clear();
				getGenerals().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_USE_CASE :
				getOwnedUseCases().clear();
				getOwnedUseCases().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__USE_CASE :
				getUseCases().clear();
				getUseCases().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__SUBSTITUTION :
				getSubstitutions().clear();
				getSubstitutions().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__REPRESENTATION :
				setRepresentation((CollaborationUse) newValue);
				return;
			case UMLPackage.COLLABORATION__COLLABORATION_USE :
				getCollaborationUses().clear();
				getCollaborationUses().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_SIGNATURE :
				setOwnedSignature((RedefinableTemplateSignature) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_BEHAVIOR :
				getOwnedBehaviors().clear();
				getOwnedBehaviors().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__CLASSIFIER_BEHAVIOR :
				setClassifierBehavior((Behavior) newValue);
				return;
			case UMLPackage.COLLABORATION__INTERFACE_REALIZATION :
				getInterfaceRealizations().clear();
				getInterfaceRealizations().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_TRIGGER :
				getOwnedTriggers().clear();
				getOwnedTriggers().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
				getOwnedConnectors().clear();
				getOwnedConnectors().addAll((Collection) newValue);
				return;
			case UMLPackage.COLLABORATION__COLLABORATION_ROLE :
				getCollaborationRoles().clear();
				getCollaborationRoles().addAll((Collection) newValue);
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
			case UMLPackage.COLLABORATION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.COLLABORATION__NAME :
				setName(NAME_EDEFAULT);
				return;
			case UMLPackage.COLLABORATION__VISIBILITY :
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case UMLPackage.COLLABORATION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.COLLABORATION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.COLLABORATION__ELEMENT_IMPORT :
				getElementImports().clear();
				return;
			case UMLPackage.COLLABORATION__PACKAGE_IMPORT :
				getPackageImports().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_RULE :
				getOwnedRules().clear();
				return;
			case UMLPackage.COLLABORATION__IS_LEAF :
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case UMLPackage.COLLABORATION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.COLLABORATION__PACKAGE :
				setPackage((org.eclipse.uml2.uml.Package) null);
				return;
			case UMLPackage.COLLABORATION__TEMPLATE_BINDING :
				getTemplateBindings().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE :
				setOwnedTemplateSignature((TemplateSignature) null);
				return;
			case UMLPackage.COLLABORATION__IS_ABSTRACT :
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case UMLPackage.COLLABORATION__GENERALIZATION :
				getGeneralizations().clear();
				return;
			case UMLPackage.COLLABORATION__POWERTYPE_EXTENT :
				getPowertypeExtents().clear();
				return;
			case UMLPackage.COLLABORATION__INHERITED_MEMBER :
				getInheritedMembers().clear();
				return;
			case UMLPackage.COLLABORATION__REDEFINED_CLASSIFIER :
				getRedefinedClassifiers().clear();
				return;
			case UMLPackage.COLLABORATION__GENERAL :
				getGenerals().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_USE_CASE :
				getOwnedUseCases().clear();
				return;
			case UMLPackage.COLLABORATION__USE_CASE :
				getUseCases().clear();
				return;
			case UMLPackage.COLLABORATION__SUBSTITUTION :
				getSubstitutions().clear();
				return;
			case UMLPackage.COLLABORATION__REPRESENTATION :
				setRepresentation((CollaborationUse) null);
				return;
			case UMLPackage.COLLABORATION__COLLABORATION_USE :
				getCollaborationUses().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_SIGNATURE :
				setOwnedSignature((RedefinableTemplateSignature) null);
				return;
			case UMLPackage.COLLABORATION__OWNED_BEHAVIOR :
				getOwnedBehaviors().clear();
				return;
			case UMLPackage.COLLABORATION__CLASSIFIER_BEHAVIOR :
				setClassifierBehavior((Behavior) null);
				return;
			case UMLPackage.COLLABORATION__INTERFACE_REALIZATION :
				getInterfaceRealizations().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_TRIGGER :
				getOwnedTriggers().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
				getOwnedAttributes().clear();
				return;
			case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
				getOwnedConnectors().clear();
				return;
			case UMLPackage.COLLABORATION__COLLABORATION_ROLE :
				getCollaborationRoles().clear();
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
			case UMLPackage.COLLABORATION__EANNOTATIONS :
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.COLLABORATION__OWNER :
				return isSetOwner();
			case UMLPackage.COLLABORATION__OWNED_COMMENT :
				List ownedComment = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.COLLABORATION__NAME :
				String name = (String) eVirtualGet(
					UMLPackage.COLLABORATION__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case UMLPackage.COLLABORATION__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.COLLABORATION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.COLLABORATION__CLIENT_DEPENDENCY :
				List clientDependency = (List) eVirtualGet(UMLPackage.COLLABORATION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.COLLABORATION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.COLLABORATION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.COLLABORATION__NAME_EXPRESSION) != null;
			case UMLPackage.COLLABORATION__ELEMENT_IMPORT :
				List elementImport = (List) eVirtualGet(UMLPackage.COLLABORATION__ELEMENT_IMPORT);
				return elementImport != null && !elementImport.isEmpty();
			case UMLPackage.COLLABORATION__PACKAGE_IMPORT :
				List packageImport = (List) eVirtualGet(UMLPackage.COLLABORATION__PACKAGE_IMPORT);
				return packageImport != null && !packageImport.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_RULE :
				List ownedRule = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_RULE);
				return ownedRule != null && !ownedRule.isEmpty();
			case UMLPackage.COLLABORATION__MEMBER :
				return isSetMembers();
			case UMLPackage.COLLABORATION__IMPORTED_MEMBER :
				return !getImportedMembers().isEmpty();
			case UMLPackage.COLLABORATION__OWNED_MEMBER :
				return isSetOwnedMembers();
			case UMLPackage.COLLABORATION__IS_LEAF :
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UMLPackage.COLLABORATION__REDEFINED_ELEMENT :
				return isSetRedefinedElements();
			case UMLPackage.COLLABORATION__REDEFINITION_CONTEXT :
				return isSetRedefinitionContexts();
			case UMLPackage.COLLABORATION__TEMPLATE_PARAMETER :
				return isSetTemplateParameter();
			case UMLPackage.COLLABORATION__OWNING_TEMPLATE_PARAMETER :
				return basicGetOwningTemplateParameter() != null;
			case UMLPackage.COLLABORATION__PACKAGE :
				return getPackage() != null;
			case UMLPackage.COLLABORATION__TEMPLATE_BINDING :
				List templateBinding = (List) eVirtualGet(UMLPackage.COLLABORATION__TEMPLATE_BINDING);
				return templateBinding != null && !templateBinding.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE :
				return eVirtualGet(UMLPackage.COLLABORATION__OWNED_TEMPLATE_SIGNATURE) != null;
			case UMLPackage.COLLABORATION__IS_ABSTRACT :
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case UMLPackage.COLLABORATION__GENERALIZATION :
				List generalization = (List) eVirtualGet(UMLPackage.COLLABORATION__GENERALIZATION);
				return generalization != null && !generalization.isEmpty();
			case UMLPackage.COLLABORATION__POWERTYPE_EXTENT :
				List powertypeExtent = (List) eVirtualGet(UMLPackage.COLLABORATION__POWERTYPE_EXTENT);
				return powertypeExtent != null && !powertypeExtent.isEmpty();
			case UMLPackage.COLLABORATION__FEATURE :
				return isSetFeatures();
			case UMLPackage.COLLABORATION__INHERITED_MEMBER :
				return !getInheritedMembers().isEmpty();
			case UMLPackage.COLLABORATION__REDEFINED_CLASSIFIER :
				List redefinedClassifier = (List) eVirtualGet(UMLPackage.COLLABORATION__REDEFINED_CLASSIFIER);
				return redefinedClassifier != null
					&& !redefinedClassifier.isEmpty();
			case UMLPackage.COLLABORATION__GENERAL :
				return !getGenerals().isEmpty();
			case UMLPackage.COLLABORATION__OWNED_USE_CASE :
				List ownedUseCase = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_USE_CASE);
				return ownedUseCase != null && !ownedUseCase.isEmpty();
			case UMLPackage.COLLABORATION__USE_CASE :
				List useCase = (List) eVirtualGet(UMLPackage.COLLABORATION__USE_CASE);
				return useCase != null && !useCase.isEmpty();
			case UMLPackage.COLLABORATION__SUBSTITUTION :
				List substitution = (List) eVirtualGet(UMLPackage.COLLABORATION__SUBSTITUTION);
				return substitution != null && !substitution.isEmpty();
			case UMLPackage.COLLABORATION__ATTRIBUTE :
				return isSetAttributes();
			case UMLPackage.COLLABORATION__REPRESENTATION :
				return eVirtualGet(UMLPackage.COLLABORATION__REPRESENTATION) != null;
			case UMLPackage.COLLABORATION__COLLABORATION_USE :
				List collaborationUse = (List) eVirtualGet(UMLPackage.COLLABORATION__COLLABORATION_USE);
				return collaborationUse != null && !collaborationUse.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_SIGNATURE :
				return eVirtualGet(UMLPackage.COLLABORATION__OWNED_SIGNATURE) != null;
			case UMLPackage.COLLABORATION__OWNED_BEHAVIOR :
				List ownedBehavior = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_BEHAVIOR);
				return ownedBehavior != null && !ownedBehavior.isEmpty();
			case UMLPackage.COLLABORATION__CLASSIFIER_BEHAVIOR :
				return eVirtualGet(UMLPackage.COLLABORATION__CLASSIFIER_BEHAVIOR) != null;
			case UMLPackage.COLLABORATION__INTERFACE_REALIZATION :
				List interfaceRealization = (List) eVirtualGet(UMLPackage.COLLABORATION__INTERFACE_REALIZATION);
				return interfaceRealization != null
					&& !interfaceRealization.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_TRIGGER :
				List ownedTrigger = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_TRIGGER);
				return ownedTrigger != null && !ownedTrigger.isEmpty();
			case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
				List ownedAttribute = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE);
				return ownedAttribute != null && !ownedAttribute.isEmpty();
			case UMLPackage.COLLABORATION__PART :
				return !getParts().isEmpty();
			case UMLPackage.COLLABORATION__ROLE :
				return isSetRoles();
			case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
				List ownedConnector = (List) eVirtualGet(UMLPackage.COLLABORATION__OWNED_CONNECTOR);
				return ownedConnector != null && !ownedConnector.isEmpty();
			case UMLPackage.COLLABORATION__COLLABORATION_ROLE :
				List collaborationRole = (List) eVirtualGet(UMLPackage.COLLABORATION__COLLABORATION_ROLE);
				return collaborationRole != null
					&& !collaborationRole.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == StructuredClassifier.class) {
			switch (derivedFeatureID) {
				case UMLPackage.COLLABORATION__OWNED_ATTRIBUTE :
					return UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE;
				case UMLPackage.COLLABORATION__PART :
					return UMLPackage.STRUCTURED_CLASSIFIER__PART;
				case UMLPackage.COLLABORATION__ROLE :
					return UMLPackage.STRUCTURED_CLASSIFIER__ROLE;
				case UMLPackage.COLLABORATION__OWNED_CONNECTOR :
					return UMLPackage.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == StructuredClassifier.class) {
			switch (baseFeatureID) {
				case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE :
					return UMLPackage.COLLABORATION__OWNED_ATTRIBUTE;
				case UMLPackage.STRUCTURED_CLASSIFIER__PART :
					return UMLPackage.COLLABORATION__PART;
				case UMLPackage.STRUCTURED_CLASSIFIER__ROLE :
					return UMLPackage.COLLABORATION__ROLE;
				case UMLPackage.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR :
					return UMLPackage.COLLABORATION__OWNED_CONNECTOR;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRoles() {
		return eIsSet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE)
			|| eIsSet(UMLPackage.COLLABORATION__COLLABORATION_ROLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
			|| eIsSet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE)
			|| eIsSet(UMLPackage.COLLABORATION__OWNED_CONNECTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAttributes() {
		return super.isSetAttributes()
			|| eIsSet(UMLPackage.COLLABORATION__OWNED_ATTRIBUTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMembers() {
		return super.isSetMembers() || isSetRoles();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatures() {
		return super.isSetFeatures()
			|| eIsSet(UMLPackage.COLLABORATION__OWNED_CONNECTOR);
	}

} //CollaborationImpl