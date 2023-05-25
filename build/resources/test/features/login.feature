#Author: Juan Jose Lopez

  @HistoriaDeUsuario
  Feature: Verify the validation form
    Me as user WANT to enter the colorlib page TO verify the validation form
    @Formulariocorrecto
  Scenario Outline: verify the validation form
    Given I enter with my credentials
      | User   | Password   |
      | <User> | <Password>|
      When I proceed with the authentication
      And go to the main view of the page
      And enter submenu form validations
      And check the title of the form on the screen
      And fill all fields
        | Required   | Select   | MultipleSelect   | Url   | Email   | Password         | ConfirmPassword   | MinField   | MaxField   | Number   | Ip   | Date   | DateEarlier   |
        | <Required> | <Select> | <MultipleSelect> | <Url> | <Email> | <SecondPassword> | <ConfirmPassword> | <MinField> | <MaxField> | <Number> | <Ip> | <Date> | <DateEarlier> |
      And click button validate
      Then field required will be empty


      Examples:
        | User  | Password | Required | Select | MultipleSelect | Url               | Email            | Password       | ConfirmPassword  | MinField | MaxField | Number  | Ip          | Date       | DateEarlier |
        | admin | admin    | admin    | admin  | Tennis         | http://dfsdfd.com | optin3@gmail.com | SecondPassword | <SecondPassword> | 100345   | 204324   | 3738553 | 191.092.0.9 | 2023-05-24 | 2012/03/03  |
