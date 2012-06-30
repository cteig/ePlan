group { "puppet":
    ensure => "present",
} 

class {'postgresql::server':
    version => '9.1',
    listen => '*'
}

postgresql::db { 'familiehub':
    owner    => 'familiehub',
    password => 'hemmelig',
    locale   => 'en_US.UTF-8',
    encoding => 'UTF8',
}

