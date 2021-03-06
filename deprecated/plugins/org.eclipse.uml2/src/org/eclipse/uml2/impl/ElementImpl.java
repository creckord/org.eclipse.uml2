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
 * $Id: ElementImpl.java,v 1.43 2006/05/26 18:16:42 khussey Exp $
 */
package org.eclipse.uml2.impl;

import java.lang.reflect.Method;

import java.util.Collection;
//import java.util.Iterator;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

//import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.Comment;
import org.eclipse.uml2.Element;
import org.eclipse.uml2.UML2Factory;
import org.eclipse.uml2.UML2Package;

import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

import org.eclipse.uml2.Model;
import org.eclipse.uml2.Stereotype;

import org.eclipse.uml2.internal.operation.ElementOperations;
import org.eclipse.uml2.internal.operation.StereotypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ElementImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ElementImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.uml2.impl.ElementImpl#getOwnedComments <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl extends EModelElementImpl implements Element {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getOwnedComments() <em>Owned Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComments()
	 * @generated
	 * @ordered
	 */
	protected EList ownedComments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			EList ownedElements = (EList) cache.get(eResource, this, UML2Package.Literals.ELEMENT__OWNED_ELEMENT);
			if (ownedElements == null) {
				cache.put(eResource, this, UML2Package.Literals.ELEMENT__OWNED_ELEMENT, ownedElements = new DerivedUnionEObjectEList(Element.class, this, UML2Package.ELEMENT__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS));
			}
			return ownedElements;
		}
		return new DerivedUnionEObjectEList(Element.class, this, UML2Package.ELEMENT__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return eIsSet(UML2Package.ELEMENT__OWNED_COMMENT);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] {UML2Package.ELEMENT__OWNED_COMMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getOwner() {
		Element owner = basicGetOwner();
		return owner != null && owner.eIsProxy() ? (Element)eResolveProxy((InternalEObject)owner) : owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetOwner() {
		return basicGetOwner() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element basicGetOwner() {
		InternalEObject eInternalContainer = eInternalContainer();
		return eInternalContainer instanceof Element ? (Element) eInternalContainer : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedComments() {
		if (ownedComments == null) {
			ownedComments = new EObjectContainmentEList(Comment.class, this, UML2Package.ELEMENT__OWNED_COMMENT);
		}
		return ownedComments;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @deprecated Use #createOwnedComment() instead.
	 */
	public Comment createOwnedComment(EClass eClass) {
		Comment newOwnedComment = (Comment) eClass.getEPackage().getEFactoryInstance().create(eClass);
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.ELEMENT__OWNED_COMMENT, null, newOwnedComment));
		}
		getOwnedComments().add(newOwnedComment);
		return newOwnedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Comment createOwnedComment() {
		Comment newOwnedComment = UML2Factory.eINSTANCE.createComment();
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0, UML2Package.ELEMENT__OWNED_COMMENT, null, newOwnedComment));
		}
		getOwnedComments().add(newOwnedComment);
		return newOwnedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNotOwnSelf(DiagnosticChain diagnostics, Map context) {
		return ElementOperations.validateNotOwnSelf(this, diagnostics, context);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHasOwner(DiagnosticChain diagnostics, Map context) {
		return ElementOperations.validateHasOwner(this, diagnostics, context);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set allOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Set result = (Set) cache.get(eResource(), this, UML2Package.Literals.ELEMENT.getEOperations().get(2));
			if (result == null) {
				cache.put(eResource(), this, UML2Package.Literals.ELEMENT.getEOperations().get(2), result = ElementOperations.allOwnedElements(this));
			}
			return result;
		}
		return ElementOperations.allOwnedElements(this);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustBeOwned() {
		return ElementOperations.mustBeOwned(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2Package.ELEMENT__EANNOTATIONS:
				return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
			case UML2Package.ELEMENT__OWNED_COMMENT:
				return ((InternalEList)getOwnedComments()).basicRemove(otherEnd, msgs);
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
			case UML2Package.ELEMENT__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.ELEMENT__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.ELEMENT__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.ELEMENT__OWNED_COMMENT:
				return getOwnedComments();
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
			case UML2Package.ELEMENT__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UML2Package.ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection)newValue);
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
			case UML2Package.ELEMENT__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UML2Package.ELEMENT__OWNED_COMMENT:
				getOwnedComments().clear();
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
			case UML2Package.ELEMENT__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.ELEMENT__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.ELEMENT__OWNER:
				return isSetOwner();
			case UML2Package.ELEMENT__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}


	/**
	 * Retrieves the cache adapter for this '<em><b>Element</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The cache adapter for this '<em><b>Element</b></em>'.
	 * @generated NOT
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.INSTANCE;
	}

	// <!-- begin-custom-operations -->

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.InternalEObject#eSetResource(org.eclipse.emf.ecore.resource.Resource.Internal,
	 *      org.eclipse.emf.common.notify.NotificationChain)
	 */
	public NotificationChain eSetResource(Resource.Internal resource,
			NotificationChain notifications) {
		CacheAdapter.INSTANCE.adapt(resource);

		return super.eSetResource(resource, notifications);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.impl.EObjectImpl#eAdapters()
	 */
	public EList eAdapters() {
		EList eAdapters = super.eAdapters();

		if (eAdapters.isEmpty()) {
			CacheAdapter cacheAdapter = getCacheAdapter();

			if (cacheAdapter != null) {
				eAdapters.add(cacheAdapter);
			}
		}

		return eAdapters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.impl.EObjectImpl#eSetDeliver(boolean)
	 */
	public void eSetDeliver(boolean deliver) {

		if (deliver) {
			CacheAdapter cacheAdapter = getCacheAdapter();

			if (cacheAdapter != null) {
				getCacheAdapter().handleCrossReference(this);
			}
		}

		super.eSetDeliver(deliver);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	public boolean eNotificationRequired() {
		return getCacheAdapter() == null
			? super.eNotificationRequired()
			: eDeliver();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	public void eNotify(Notification notification) {

		if (eDeliver()) {
			BasicEList eBasicAdapters = eBasicAdapters();

			if (eBasicAdapters == null || eBasicAdapters.isEmpty()) {
				CacheAdapter cacheAdapter = getCacheAdapter();

				if (cacheAdapter != null) {
					cacheAdapter.notifyChanged(notification);
				}
			} else {
				Adapter[] adapters = (Adapter[]) eBasicAdapters.data();

				for (int i = 0, size = eBasicAdapters.size(); i < size; i++) {
					adapters[i].notifyChanged(notification);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#createEAnnotation(String)
	 */
	public EAnnotation createEAnnotation(String source) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();

		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, 0,
				EcorePackage.EMODEL_ELEMENT__EANNOTATIONS, null, eAnnotation));
		}

		eAnnotation.setSource(source);
		eAnnotation.setEModelElement(this);

		return eAnnotation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#apply(org.eclipse.uml2.Stereotype)
	 */
	public void apply(Stereotype stereotype) {
		StereotypeOperations.apply(stereotype, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getApplicableStereotype(java.lang.String)
	 */
	public Stereotype getApplicableStereotype(String qualifiedStereotypeName) {
		return StereotypeOperations.getApplicableStereotype(this,
			qualifiedStereotypeName);
	}

	private static Method GET_APPLICABLE_STEREOTYPES = null;

	static {
		try {
			GET_APPLICABLE_STEREOTYPES = ElementImpl.class.getMethod(
				"getApplicableStereotypes", null); //$NON-NLS-1$
		} catch (Exception e) {
			// ignore
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getApplicableStereotypes()
	 */
	public Set getApplicableStereotypes() {
		CacheAdapter cache = getCacheAdapter();

		if (cache != null) {
			Set result = (Set) cache.get(this, GET_APPLICABLE_STEREOTYPES);

			if (result == null) {
				cache.put(this, GET_APPLICABLE_STEREOTYPES,
					result = Collections.unmodifiableSet(StereotypeOperations
						.getApplicableStereotypes(this)));
			}

			return result;
		}

		return Collections.unmodifiableSet(StereotypeOperations
			.getApplicableStereotypes(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getAppliedStereotype(java.lang.String)
	 */
	public Stereotype getAppliedStereotype(String qualifiedStereotypeName) {
		return StereotypeOperations.getAppliedStereotype(this,
			qualifiedStereotypeName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getAppliedSubstereotype(org.eclipse.uml2.Stereotype,
	 *      java.lang.String)
	 */
	public Stereotype getAppliedSubstereotype(Stereotype superstereotype,
			String qualifiedStereotypeName) {
		return StereotypeOperations.getAppliedSubstereotype(this,
			superstereotype, qualifiedStereotypeName);
	}

	private static Method GET_APPLIED_STEREOTYPES = null;

	static {
		try {
			GET_APPLIED_STEREOTYPES = ElementImpl.class.getMethod(
				"getAppliedStereotypes", null); //$NON-NLS-1$
		} catch (Exception e) {
			// ignore
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getAppliedStereotypes()
	 */
	public Set getAppliedStereotypes() {
		CacheAdapter cache = getCacheAdapter();

		if (cache != null) {
			Set result = (Set) cache.get(this, GET_APPLIED_STEREOTYPES);

			if (result == null) {
				cache.put(this, GET_APPLIED_STEREOTYPES, result = Collections
					.unmodifiableSet(StereotypeOperations
						.getAppliedStereotypes(this)));
			}

			return result;
		}

		return Collections.unmodifiableSet(StereotypeOperations
			.getAppliedStereotypes(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getAppliedSubstereotypes(org.eclipse.uml2.Stereotype)
	 */
	public Set getAppliedSubstereotypes(Stereotype superstereotype) {
		return StereotypeOperations.getAppliedSubstereotypes(this,
			superstereotype);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getModel()
	 */
	public Model getModel() {
		return ElementOperations.getModel(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getNearestPackage()
	 */
	public org.eclipse.uml2.Package getNearestPackage() {
		return ElementOperations.getNearestPackage(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getValue(org.eclipse.uml2.Stereotype,
	 *      java.lang.String)
	 */
	public Object getValue(Stereotype stereotype, String propertyName) {
		return StereotypeOperations.getValue(stereotype, this, propertyName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#isApplied(org.eclipse.uml2.Stereotype)
	 */
	public boolean isApplied(Stereotype stereotype) {
		return StereotypeOperations.isApplied(stereotype, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#isRequired(org.eclipse.uml2.Stereotype)
	 */
	public boolean isRequired(Stereotype stereotype) {
		return StereotypeOperations.isRequired(stereotype, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#setValue(org.eclipse.uml2.Stereotype,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setValue(Stereotype stereotype, String propertyName,
			Object value) {
		StereotypeOperations.setValue(stereotype, this, propertyName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#hasValue(org.eclipse.uml2.Stereotype,
	 *      java.lang.String)
	 */
	public boolean hasValue(Stereotype stereotype, String propertyName) {
		return StereotypeOperations.hasValue(stereotype, this, propertyName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#unapply(org.eclipse.uml2.Stereotype)
	 */
	public void unapply(Stereotype stereotype) {
		StereotypeOperations.unapply(stereotype, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#destroy()
	 */
	public void destroy() {
		ElementOperations.destroy(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getAppliedVersion(org.eclipse.uml2.Stereotype)
	 */
	public String getAppliedVersion(Stereotype stereotype) {
		return StereotypeOperations.getAppliedVersion(stereotype, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#addKeyword(java.lang.String)
	 */
	public void addKeyword(String keyword) {
		ElementOperations.addKeyword(this, keyword);
	}

	private static Method GET_KEYWORDS = null;

	static {
		try {
			GET_KEYWORDS = ElementImpl.class.getMethod("getKeywords", null); //$NON-NLS-1$
		} catch (Exception e) {
			// ignore
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#getKeywords()
	 */
	public Set getKeywords() {
		CacheAdapter cache = getCacheAdapter();

		if (cache != null) {
			Set result = (Set) cache.get(eResource(), this, GET_KEYWORDS);

			if (result == null) {
				cache.put(eResource(), this, GET_KEYWORDS, result = Collections
					.unmodifiableSet(ElementOperations.getKeywords(this)));
			}

			return result;
		}

		return Collections.unmodifiableSet(ElementOperations.getKeywords(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#hasKeyword(java.lang.String)
	 */
	public boolean hasKeyword(String keyword) {
		return ElementOperations.hasKeyword(this, keyword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.uml2.Element#removeKeyword(java.lang.String)
	 */
	public void removeKeyword(String keyword) {
		ElementOperations.removeKeyword(this, keyword);
	}
	
	// <!-- end-custom-operations -->

} //ElementImpl
