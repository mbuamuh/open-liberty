-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName = io.openliberty.openidConnectServer1.0.internal.ee-10.0
singleton=true
visibility = private
-features=com.ibm.websphere.appserver.servlet-6.0, \
  io.openliberty.pages-3.1, \
  io.openliberty.jakarta.cdi-4.0; apiJar=false
-bundles=\
  io.openliberty.security.common.internal, \
  io.openliberty.security.openidconnect.internal.clients.common, \
  io.openliberty.security.openidconnect.internal.server, \
  io.openliberty.security.oidcclientcore.internal.jakarta
kind=beta
edition=core
