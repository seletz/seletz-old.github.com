import wt.method.RemoteMethodServer
import com.ptc.wvs.server.util.PublishUtils


def login(args) {
    ms = RemoteMethodServer.getDefault()
    ms.setUserName(args.user)
    ms.setPassword(args.password)
    
    return ms
}

def getObjectFromOR = { oid ->
    PublishUtils.getObjectFromRef(oid)
}

def getORFromObject = { obj ->
    PublishUtils.getRefFromObject(obj)    
}

// log in
login(user: "orgadmin", password: "orgadmin")

// fetch a object by using a OR
def oid = "VR:wt.epm.EPMDocument:8483330"
def doc = getObjectFromOR(oid)

// We're able to access the properties of the EPMDocument
println "${doc.displayIdentifier} [${doc.state} ${doc.type}] ${getORFromObject(doc)}"

// for the "inspact last" feature of groovyConsole 
return doc 