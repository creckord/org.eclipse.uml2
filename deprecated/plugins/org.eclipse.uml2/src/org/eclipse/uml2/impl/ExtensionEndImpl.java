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
 * $Id: ExtensionEndImpl.java,v 1.20 2006/04/10 20:40:18 khussey Exp $
 */
package org.eclipse.uml2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.ExtensionEnd;
import org.eclipse.uml2.Stereotype;
import org.eclipse.uml2.Type;
import org.eclipse.uml2.UML2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.impl.ExtensionEndImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionEndImpl extends PropertyImpl implements ExtensionEnd {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) IBM Corporation and others."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UML2Package.Literals.EXTENSION_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2Package.EXTENSION_END__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(Type newType) {
		if (newType != null && !(newType instanceof Stereotype)) {
			throw new IllegalArgumentException(String.valueOf(newType));
		}
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2Package.EXTENSION_END__TYPE, oldType, type));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return type != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UML2Package.EXTENSION_END__EANNOTATIONS:
				return getEAnnotations();
			case UML2Package.EXTENSION_END__OWNED_ELEMENT:
				return getOwnedElements();
			case UML2Package.EXTENSION_END__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case UML2Package.EXTENSION_END__OWNED_COMMENT:
				return getOwnedComments();
			case UML2Package.EXTENSION_END__TEMPLATE_BINDING:
				return getTemplateBindings();
			case UML2Package.EXTENSION_END__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case UML2Package.EXTENSION_END__NAME:
				return getName();
			case UML2Package.EXTENSION_END__QUALIFIED_NAME:
				return getQualifiedName();
			case UML2Package.EXTENSION_END__VISIBILITY:
				return getVisibility();
			case UML2Package.EXTENSION_END__CLIENT_DEPENDENCY:
				return getClientDependencies();
			case UML2Package.EXTENSION_END__NAME_EXPRESSION:
				return getNameExpression();
			case UML2Package.EXTENSION_END__REDEFINITION_CONTEXT:
				return getRedefinitionContexts();
			case UML2Package.EXTENSION_END__IS_LEAF:
				return isLeaf() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__FEATURING_CLASSIFIER:
				return getFeaturingClassifiers();
			case UML2Package.EXTENSION_END__IS_STATIC:
				return isStatic() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case UML2Package.EXTENSION_END__IS_ORDERED:
				return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__IS_UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__LOWER:
				return new Integer(getLower());
			case UML2Package.EXTENSION_END__UPPER:
				return new Integer(getUpper());
			case UML2Package.EXTENSION_END__UPPER_VALUE:
				return getUpperValue();
			case UML2Package.EXTENSION_END__LOWER_VALUE:
				return getLowerValue();
			case UML2Package.EXTENSION_END__IS_READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case UML2Package.EXTENSION_END__OWNING_PARAMETER:
				return getOwningParameter();
			case UML2Package.EXTENSION_END__END:
				return getEnds();
			case UML2Package.EXTENSION_END__DEPLOYMENT:
				return getDeployments();
			case UML2Package.EXTENSION_END__DEPLOYED_ELEMENT:
				return getDeployedElements();
			case UML2Package.EXTENSION_END__DEFAULT:
				return getDefault();
			case UML2Package.EXTENSION_END__IS_COMPOSITE:
				return isComposite() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__IS_DERIVED:
				return isDerived() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__CLASS_:
				return getClass_();
			case UML2Package.EXTENSION_END__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case UML2Package.EXTENSION_END__IS_DERIVED_UNION:
				return isDerivedUnion() ? Boolean.TRUE : Boolean.FALSE;
			case UML2Package.EXTENSION_END__OWNING_ASSOCIATION:
				return getOwningAssociation();
			case UML2Package.EXTENSION_END__REDEFINED_PROPERTY:
				return getRedefinedProperties();
			case UML2Package.EXTENSION_END__SUBSETTED_PROPERTY:
				return getSubsettedProperties();
			case UML2Package.EXTENSION_END__DATATYPE:
				return getDatatype();
			case UML2Package.EXTENSION_END__ASSOCIATION:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case UML2Package.EXTENSION_END__AGGREGATION:
				return getAggregation();
			case UML2Package.EXTENSION_END__DEFAULT_VALUE:
				return getDefaultValue();
			case UML2Package.EXTENSION_END__QUALIFIER:
				return getQualifiers();
			case UML2Package.EXTENSION_END__ASSOCIATION_END:
				return getAssociationEnd();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UML2Package.EXTENSION_END__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UML2Package.EXTENSION_END__OWNED_ELEMENT:
				return isSetOwnedElements();
			case UML2Package.EXTENSION_END__OWNER:
				return isSetOwner();
			case UML2Package.EXTENSION_END__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case UML2Package.EXTENSION_END__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case UML2Package.EXTENSION_END__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case UML2Package.EXTENSION_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2Package.EXTENSION_END__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case UML2Package.EXTENSION_END__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case UML2Package.EXTENSION_END__CLIENT_DEPENDENCY:
				return clientDependencies != null && !clientDependencies.isEmpty();
			case UML2Package.EXTENSION_END__NAME_EXPRESSION:
				return nameExpression != null;
			case UML2Package.EXTENSION_END__REDEFINITION_CONTEXT:
				return isSetRedefinitionContexts();
			case UML2Package.EXTENSION_END__IS_LEAF:
				return ((eFlags & IS_LEAF_EFLAG) != 0) != IS_LEAF_EDEFAULT;
			case UML2Package.EXTENSION_END__FEATURING_CLASSIFIER:
				return isSetFeaturingClassifiers();
			case UML2Package.EXTENSION_END__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case UML2Package.EXTENSION_END__TYPE:
				return isSetType();
			case UML2Package.EXTENSION_END__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case UML2Package.EXTENSION_END__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case UML2Package.EXTENSION_END__LOWER:
				return getLower() != LOWER_EDEFAULT;
			case UML2Package.EXTENSION_END__UPPER:
				return getUpper() != UPPER_EDEFAULT;
			case UML2Package.EXTENSION_END__UPPER_VALUE:
				return upperValue != null;
			case UML2Package.EXTENSION_END__LOWER_VALUE:
				return lowerValue != null;
			case UML2Package.EXTENSION_END__IS_READ_ONLY:
				return isSetIsReadOnly();
			case UML2Package.EXTENSION_END__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case UML2Package.EXTENSION_END__OWNING_PARAMETER:
				return getOwningParameter() != null;
			case UML2Package.EXTENSION_END__END:
				return ends != null && !ends.isEmpty();
			case UML2Package.EXTENSION_END__DEPLOYMENT:
				return deployments != null && !deployments.isEmpty();
			case UML2Package.EXTENSION_END__DEPLOYED_ELEMENT:
				return !getDeployedElements().isEmpty();
			case UML2Package.EXTENSION_END__DEFAULT:
				return DEFAULT_EDEFAULT == null ? getDefault() != null : !DEFAULT_EDEFAULT.equals(getDefault());
			case UML2Package.EXTENSION_END__IS_COMPOSITE:
				return isComposite() != IS_COMPOSITE_EDEFAULT;
			case UML2Package.EXTENSION_END__IS_DERIVED:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case UML2Package.EXTENSION_END__CLASS_:
				return getClass_() != null;
			case UML2Package.EXTENSION_END__OPPOSITE:
				return basicGetOpposite() != null;
			case UML2Package.EXTENSION_END__IS_DERIVED_UNION:
				return ((eFlags & IS_DERIVED_UNION_EFLAG) != 0) != IS_DERIVED_UNION_EDEFAULT;
			case UML2Package.EXTENSION_END__OWNING_ASSOCIATION:
				return getOwningAssociation() != null;
			case UML2Package.EXTENSION_END__REDEFINED_PROPERTY:
				return redefinedProperties != null && !redefinedProperties.isEmpty();
			case UML2Package.EXTENSION_END__SUBSETTED_PROPERTY:
				return subsettedProperties != null && !subsettedProperties.isEmpty();
			case UML2Package.EXTENSION_END__DATATYPE:
				return getDatatype() != null;
			case UML2Package.EXTENSION_END__ASSOCIATION:
				return association != null;
			case UML2Package.EXTENSION_END__AGGREGATION:
				return aggregation != AGGREGATION_EDEFAULT;
			case UML2Package.EXTENSION_END__DEFAULT_VALUE:
				return defaultValue != null;
			case UML2Package.EXTENSION_END__QUALIFIER:
				return qualifiers != null && !qualifiers.isEmpty();
			case UML2Package.EXTENSION_END__ASSOCIATION_END:
				return getAssociationEnd() != null;
		}
		return eDynamicIsSet(featureID);
	}


} //ExtensionEndImpl
