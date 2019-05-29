from flask import Flask, render_template, request, url_for, redirect
from flask_bootstrap import Bootstrap
from flask_sqlalchemy import SQLAlchemy
from flask_script import Manager
from flask_migrate import Migrate
from Company import Company

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///db.sqlite'
bootstrap = Bootstrap(app)
db = SQLAlchemy(app)

@app.route('/')
def index():
	return render_template('index.html')

@app.route('/cadastrar')
def cadastrar():
	return render_template('main/pag-cadastro.html')

@app.route('/cadastro', methods=["GET", "POST"])
def cadastro():
	default_name = '0'
	ncompany = request.form.get('inputNomeEmpresa',default_name)
	cnpj = request.form.get('inputCNPJ',default_name)
	owner = request.form.get('inputProprietario',default_name)
	email = request.form.get('inputEmail',default_name)
	address = request.form.get('inputAddress',default_name)
	city = request.form.get('inputCity',default_name)
	state = request.form.get('inputState',default_name)
	cep = request.form.get('inputCEP',default_name)
	password = request.form.get('inputPassword',default_name)
	confirmPassword = request.form.get('inputConfirmPassword',default_name)
	
	print(type(ncompany))
	#verificar se as senhas sao iguais	
	if ncompany and cnpj and owner and email and address and city and cep and password:
		comp = Company(ncompany, cnpj, owner, email, address, city, state, cep, password)
		db.session.add(comp)

	return redirect(url_for('index'))

@app.route('/controleEstacionamento')
def controleEstacionamento():
	return render_template('main/pag-gerencEstacionamento.html')

if __name__ == '__main__':
	app.run(debug=True)
