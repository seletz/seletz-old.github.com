import wt.method.RemoteMethodServer
import com.ptc.wvs.server.util.PublishUtils
import wt.vc.VersionControlHelper as VCH

def login(args) {
    ms = RemoteMethodServer.getDefault()
    ms.setUserName(args.user)
    ms.setPassword(args.password)
    
    return ms
}

def getObjectFromOR(oid) {
    PublishUtils.getObjectFromRef(oid)
}

def getORFromObject(obj) {
    PublishUtils.getRefFromObject(obj)    
}

def info(doc) {
    "${doc.displayIdentifier} [${doc.state} ${doc.type}] ${getORFromObject(doc)}"    
}

// log in
login(user: "orgadmin", password: "orgadmin")

// fetch a object by using a OR
def oid = "VR:wt.epm.EPMDocument:8483330"
def doc = getObjectFromOR(oid)

VCH.service.allIterationsOf(doc.master).each { obj ->
    println info(obj)
}
