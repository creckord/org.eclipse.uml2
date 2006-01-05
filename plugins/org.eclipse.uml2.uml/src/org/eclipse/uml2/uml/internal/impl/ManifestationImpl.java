/*
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: ManifestationImpl.java,v 1.9 2006/01/05 13:54:02 khussey Exp $
 */
package org.eclipse.uml2.uml.internal.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.common.util.SubsetSupersetEObjectResolvingEList;

import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manifestation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ManifestationImpl#getSuppliers <em>Supplier</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.internal.impl.ManifestationImpl#getUtilizedElement <em>Utilized Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManifestationImpl
		extends AbstractionImpl
		implements Manifestation {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManifestationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UMLPackage.Literals.MANIFESTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuppliers() {
		EList supplier = (EList) eVirtualGet(UMLPackage.MANIFESTATION__SUPPLIER);
		if (supplier == null) {
			eVirtualSet(UMLPackage.MANIFESTATION__SUPPLIER,
				supplier = new SubsetSupersetEObjectResolvingEList(
					NamedElement.class, this,
					UMLPackage.MANIFESTATION__SUPPLIER, null,
					new int[]{UMLPackage.MANIFESTATION__UTILIZED_ELEMENT}));
		}
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement getUtilizedElement() {
		PackageableElement utilizedElement = (PackageableElement) eVirtualGet(UMLPackage.MANIFESTATION__UTILIZED_ELEMENT);
		if (utilizedElement != null && utilizedElement.eIsProxy()) {
			InternalEObject oldUtilizedElement = (InternalEObject) utilizedElement;
			utilizedElement = (PackageableElement) eResolveProxy(oldUtilizedElement);
			if (utilizedElement != oldUtilizedElement) {
				eVirtualSet(UMLPackage.MANIFESTATION__UTILIZED_ELEMENT,
					utilizedElement);
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.MANIFESTATION__UTILIZED_ELEMENT,
						oldUtilizedElement, utilizedElement));
			}
		}
		return utilizedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement basicGetUtilizedElement() {
		return (PackageableElement) eVirtualGet(UMLPackage.MANIFESTATION__UTILIZED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizedElement(PackageableElement newUtilizedElement) {
		if (newUtilizedElement != null
			&& !getSuppliers().contains(newUtilizedElement)) {
			getSuppliers().add(newUtilizedElement);
		}
		PackageableElement utilizedElement = newUtilizedElement;
		Object oldUtilizedElement = eVirtualSet(
			UMLPackage.MANIFESTATION__UTILIZED_ELEMENT, utilizedElement);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MANIFESTATION__UTILIZED_ELEMENT,
				oldUtilizedElement == EVIRTUAL_NO_VALUE
					? null
					: oldUtilizedElement, utilizedElement));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.MANIFESTATION__EANNOTATIONS :
				return getEAnnotations();
			case UMLPackage.MANIFESTATION__OWNED_ELEMENT :
				return getOwnedElements();
			case UMLPackage.MANIFESTATION__OWNER :
				if (resolve)
					return getOwner();
				return basicGetOwner();
			case UMLPackage.MANIFESTATION__OWNED_COMMENT :
				return getOwnedComments();
			case UMLPackage.MANIFESTATION__NAME :
				return getName();
			case UMLPackage.MANIFESTATION__VISIBILITY :
				return getVisibility();
			case UMLPackage.MANIFESTATION__QUALIFIED_NAME :
				return getQualifiedName();
			case UMLPackage.MANIFESTATION__CLIENT_DEPENDENCY :
				return getClientDependencies();
			case UMLPackage.MANIFESTATION__NAMESPACE :
				if (resolve)
					return getNamespace();
				return basicGetNamespace();
			case UMLPackage.MANIFESTATION__NAME_EXPRESSION :
				return getNameExpression();
			case UMLPackage.MANIFESTATION__OWNING_TEMPLATE_PARAMETER :
				if (resolve)
					return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case UMLPackage.MANIFESTATION__TEMPLATE_PARAMETER :
				if (resolve)
					return getTemplateParameter();
				return basicGetTemplateParameter();
			case UMLPackage.MANIFESTATION__RELATED_ELEMENT :
				return getRelatedElements();
			case UMLPackage.MANIFESTATION__SOURCE :
				return getSources();
			case UMLPackage.MANIFESTATION__TARGET :
				return getTargets();
			case UMLPackage.MANIFESTATION__SUPPLIER :
				return getSuppliers();
			case UMLPackage.MANIFESTATION__CLIENT :
				return getClients();
			case UMLPackage.MANIFESTATION__MAPPING :
				return getMapping();
			case UMLPackage.MANIFESTATION__UTILIZED_ELEMENT :
				if (resolve)
					return getUtilizedElement();
				return basicGetUtilizedElement();
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
			case UMLPackage.MANIFESTATION__EANNOTATIONS :
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection) newValue);
				return;
			case UMLPackage.MANIFESTATION__OWNED_COMMENT :
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection) newValue);
				return;
			case UMLPackage.MANIFESTATION__NAME :
				setName((String) newValue);
				return;
			case UMLPackage.MANIFESTATION__VISIBILITY :
				setVisibility((VisibilityKind) newValue);
				return;
			case UMLPackage.MANIFESTATION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				getClientDependencies().addAll((Collection) newValue);
				return;
			case UMLPackage.MANIFESTATION__NAME_EXPRESSION :
				setNameExpression((StringExpression) newValue);
				return;
			case UMLPackage.MANIFESTATION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.MANIFESTATION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) newValue);
				return;
			case UMLPackage.MANIFESTATION__SUPPLIER :
				getSuppliers().clear();
				getSuppliers().addAll((Collection) newValue);
				return;
			case UMLPackage.MANIFESTATION__CLIENT :
				getClients().clear();
				getClients().addAll((Collection) newValue);
				return;
			case UMLPackage.MANIFESTATION__MAPPING :
				setMapping((OpaqueExpression) newValue);
				return;
			case UMLPackage.MANIFESTATION__UTILIZED_ELEMENT :
				setUtilizedElement((PackageableElement) newValue);
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
			case UMLPackage.MANIFESTATION__EANNOTATIONS :
				getEAnnotations().clear();
				return;
			case UMLPackage.MANIFESTATION__OWNED_COMMENT :
				getOwnedComments().clear();
				return;
			case UMLPackage.MANIFESTATION__NAME :
				unsetName();
				return;
			case UMLPackage.MANIFESTATION__VISIBILITY :
				unsetVisibility();
				return;
			case UMLPackage.MANIFESTATION__CLIENT_DEPENDENCY :
				getClientDependencies().clear();
				return;
			case UMLPackage.MANIFESTATION__NAME_EXPRESSION :
				setNameExpression((StringExpression) null);
				return;
			case UMLPackage.MANIFESTATION__OWNING_TEMPLATE_PARAMETER :
				setOwningTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.MANIFESTATION__TEMPLATE_PARAMETER :
				setTemplateParameter((TemplateParameter) null);
				return;
			case UMLPackage.MANIFESTATION__SUPPLIER :
				getSuppliers().clear();
				return;
			case UMLPackage.MANIFESTATION__CLIENT :
				getClients().clear();
				return;
			case UMLPackage.MANIFESTATION__MAPPING :
				setMapping((OpaqueExpression) null);
				return;
			case UMLPackage.MANIFESTATION__UTILIZED_ELEMENT :
				setUtilizedElement((PackageableElement) null);
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
			case UMLPackage.MANIFESTATION__EANNOTATIONS :
				EList eAnnotations = (EList) eVirtualGet(UMLPackage.MANIFESTATION__EANNOTATIONS);
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UMLPackage.MANIFESTATION__OWNED_ELEMENT :
				return isSetOwnedElements();
			case UMLPackage.MANIFESTATION__OWNER :
				return isSetOwner();
			case UMLPackage.MANIFESTATION__OWNED_COMMENT :
				EList ownedComment = (EList) eVirtualGet(UMLPackage.MANIFESTATION__OWNED_COMMENT);
				return ownedComment != null && !ownedComment.isEmpty();
			case UMLPackage.MANIFESTATION__NAME :
				return isSetName();
			case UMLPackage.MANIFESTATION__VISIBILITY :
				return isSetVisibility();
			case UMLPackage.MANIFESTATION__QUALIFIED_NAME :
				return QUALIFIED_NAME_EDEFAULT == null
					? getQualifiedName() != null
					: !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UMLPackage.MANIFESTATION__CLIENT_DEPENDENCY :
				EList clientDependency = (EList) eVirtualGet(UMLPackage.MANIFESTATION__CLIENT_DEPENDENCY);
				return clientDependency != null && !clientDependency.isEmpty();
			case UMLPackage.MANIFESTATION__NAMESPACE :
				return isSetNamespace();
			case UMLPackage.MANIFESTATION__NAME_EXPRESSION :
				return eVirtualGet(UMLPackage.MANIFESTATION__NAME_EXPRESSION) != null;
			case UMLPackage.MANIFESTATION__OWNING_TEMPLATE_PARAMETER :
				return basicGetOwningTemplateParameter() != null;
			case UMLPackage.MANIFESTATION__TEMPLATE_PARAMETER :
				return eVirtualGet(UMLPackage.MANIFESTATION__TEMPLATE_PARAMETER) != null;
			case UMLPackage.MANIFESTATION__RELATED_ELEMENT :
				return isSetRelatedElements();
			case UMLPackage.MANIFESTATION__SOURCE :
				return isSetSources();
			case UMLPackage.MANIFESTATION__TARGET :
				return isSetTargets();
			case UMLPackage.MANIFESTATION__SUPPLIER :
				EList supplier = (EList) eVirtualGet(UMLPackage.MANIFESTATION__SUPPLIER);
				return supplier != null && !supplier.isEmpty();
			case UMLPackage.MANIFESTATION__CLIENT :
				EList client = (EList) eVirtualGet(UMLPackage.MANIFESTATION__CLIENT);
				return client != null && !client.isEmpty();
			case UMLPackage.MANIFESTATION__MAPPING :
				return eVirtualGet(UMLPackage.MANIFESTATION__MAPPING) != null;
			case UMLPackage.MANIFESTATION__UTILIZED_ELEMENT :
				return eVirtualGet(UMLPackage.MANIFESTATION__UTILIZED_ELEMENT) != null;
		}
		return eDynamicIsSet(featureID);
	}

} //ManifestationImpl
